package com.sims.daniel.baseapplication.data.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.sims.daniel.baseapplication.data.models.TestModel;

import java.util.List;

@Dao
public interface TestModelDao {

    @Query("SELECT * FROM TestModel")
    LiveData<List<TestModel>> getAll();

    @Insert
    void insertAll(List<TestModel> testModels);

    @Insert
    void insert(TestModel testModel);

    @Update
    void update(TestModel testModel);

    @Delete
    void delete(TestModel testModel);
}
