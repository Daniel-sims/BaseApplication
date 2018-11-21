package com.sims.daniel.baseapplication.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Message {

    @PrimaryKey(autoGenerate = true)
    private int mId;

    @ColumnInfo(name = "message")
    private String mMessage;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
