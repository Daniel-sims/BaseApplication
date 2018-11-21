package com.sims.daniel.baseapplication.data.daos;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.List;

public interface BaseDao<T> {

    @Insert
    void insertAll(List<T> testModels);

    @Insert
    void insert(T testModel);

    @Update
    void update(T testModel);

    @Delete
    void delete(T testModel);
}
