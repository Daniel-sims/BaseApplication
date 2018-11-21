package com.sims.daniel.baseapplication.features.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.sims.daniel.baseapplication.data.models.Message;
import com.sims.daniel.baseapplication.data.repositories.MessageRepository;

import java.util.List;

import javax.inject.Inject;

public class ListViewModel extends ViewModel {

    @Inject
    MessageRepository mMessageRepository;

    @Inject
    public ListViewModel() {

    }

    public void insertMessage(@Nullable Message message) {
        if(message != null) {
            new Thread(() -> mMessageRepository.insertMessage(message)).start();
        }
    }

    public LiveData<List<Message>> getMessages() {
        return mMessageRepository.getMessages();
    }
}
