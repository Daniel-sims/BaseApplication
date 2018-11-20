package com.sims.daniel.baseapplication.features.home;

import android.arch.lifecycle.ViewModel;

import com.sims.daniel.baseapplication.utils.ProjectApplicationCache;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    @Inject
    ProjectApplicationCache mProjectApplicationCache;

    @Inject
    public HomeViewModel() {

    }
}
