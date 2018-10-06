package com.sims.daniel.baseapplication.dependencies.modules;

import com.sims.daniel.baseapplication.features.application.ProjectApplication;

import dagger.Module;

@Module
public class AppModule {
    private final ProjectApplication mProjectApplication;

    public AppModule(ProjectApplication projectApplication) {
        mProjectApplication = projectApplication;
    }

}
