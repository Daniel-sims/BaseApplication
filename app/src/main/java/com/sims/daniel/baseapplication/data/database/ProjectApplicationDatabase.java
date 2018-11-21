package com.sims.daniel.baseapplication.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sims.daniel.baseapplication.data.daos.TestModelDao;
import com.sims.daniel.baseapplication.data.models.TestModel;

import static com.sims.daniel.baseapplication.utils.ProjectApplicationConstants.DATABASE_VERSION;

@Database(entities = {TestModel.class}, version = DATABASE_VERSION)
public abstract class ProjectApplicationDatabase extends RoomDatabase {
    public abstract TestModelDao testModelDao();
}
