package com.sims.daniel.baseapplication.dependencies.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.sims.daniel.baseapplication.data.daos.TestModelDao;
import com.sims.daniel.baseapplication.data.database.ProjectApplicationDatabase;
import com.sims.daniel.baseapplication.data.repositories.TestModelRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.sims.daniel.baseapplication.utils.ProjectApplicationConstants.DATABASE_NAME;

@Module
public class DataProviderModule {

    @Provides
    @Singleton
    ProjectApplicationDatabase provideProjectApplicationDatabase(Context projectApplicationContext) {
        return Room.databaseBuilder(
                projectApplicationContext,
                ProjectApplicationDatabase.class,
                DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    TestModelDao provideTestModelDao(ProjectApplicationDatabase projectApplicationDatabase) {
        return projectApplicationDatabase.testModelDao();
    }

    @Singleton
    @Provides
    TestModelRepository provideTestModelRepository(TestModelDao testModelDao) {
        return new TestModelRepository(testModelDao);
    }
}
