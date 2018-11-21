package com.sims.daniel.baseapplication.features.application;

import android.app.Application;

import com.sims.daniel.baseapplication.dependencies.components.AppComponent;
import com.sims.daniel.baseapplication.dependencies.components.DaggerAppComponent;
import com.sims.daniel.baseapplication.dependencies.modules.AppModule;

import timber.log.Timber;

public class ProjectApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        initDagger();
    }

    private void initDatabase() {

    }

    private void initDagger() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}

