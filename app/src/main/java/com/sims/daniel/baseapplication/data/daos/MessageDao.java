package com.sims.daniel.baseapplication.data.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.sims.daniel.baseapplication.data.models.Message;

import java.util.List;

@Dao
public interface MessageDao extends BaseDao<Message> {

    @Query("SELECT * FROM Message")
    LiveData<List<Message>> getAll();
}
