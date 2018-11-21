package com.sims.daniel.baseapplication.dependencies.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.sims.daniel.baseapplication.features.application.ProjectApplication;
import com.sims.daniel.baseapplication.utils.ProjectApplicationCache;
import com.sims.daniel.baseapplication.utils.ProjectApplicationConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final ProjectApplication mProjectApplication;

    public AppModule(ProjectApplication projectApplication) {
        mProjectApplication = projectApplication;
    }

    @Singleton
    @Provides
    public Context provideApplicationContext() {
        return mProjectApplication;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreference(Context context) {
        return context.getSharedPreferences(ProjectApplicationConstants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    ProjectApplicationCache provideProjectApplicationCache(SharedPreferences sharedPreferences) {
        return new ProjectApplicationCache(sharedPreferences);
    }
}
