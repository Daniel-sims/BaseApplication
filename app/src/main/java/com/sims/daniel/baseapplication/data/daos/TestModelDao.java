package com.sims.daniel.baseapplication.data.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.sims.daniel.baseapplication.data.models.TestModel;

import java.util.List;

@Dao
public interface TestModelDao extends BaseDao<TestModel>{

    @Query("SELECT * FROM TestModel")
    LiveData<List<TestModel>> getAll();

}
