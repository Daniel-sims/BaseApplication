package com.sims.daniel.baseapplication.data.repositories;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sims.daniel.baseapplication.data.daos.MessageDao;
import com.sims.daniel.baseapplication.data.models.Message;

import java.util.List;

public class MessageRepository {

    private final MessageDao mMessageDao;

    public MessageRepository(MessageDao messageDao) {
        mMessageDao = messageDao;
    }

    public LiveData<List<Message>> getMessages() {
        return mMessageDao.getAll();
    }

    public void insertMessage(@NonNull Message message) {
        new Thread(() -> mMessageDao.insert(message)).start();
    }

    public void insertMessageList(@NonNull List<Message> message) {
        new Thread(() -> mMessageDao.insertAll(message)).start();
    }

    public void updateMessage(@NonNull Message message) {
        new Thread(() -> mMessageDao.update(message)).start();
    }

    public void deleteMessage(@NonNull Message message) {
        new Thread(() -> mMessageDao.delete(message)).start();
    }
}
