package com.sims.daniel.baseapplication.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class TestModel {

    @PrimaryKey(autoGenerate = true)
    private int mId;

    @ColumnInfo(name = "name")
    private String mTestModelName;

    @ColumnInfo(name = "counter")
    private int mCounter;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTestModelName() {
        return mTestModelName;
    }

    public void setTestModelName(String testModelName) {
        mTestModelName = testModelName;
    }

    public int getCounter() {
        return mCounter;
    }

    public void setCounter(int counter) {
        mCounter = counter;
    }
}
