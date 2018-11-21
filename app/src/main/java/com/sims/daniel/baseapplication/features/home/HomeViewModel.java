package com.sims.daniel.baseapplication.features.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.sims.daniel.baseapplication.data.models.TestModel;
import com.sims.daniel.baseapplication.data.repositories.TestModelRepository;
import com.sims.daniel.baseapplication.utils.ProjectApplicationCache;

import java.util.List;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    @Inject
    ProjectApplicationCache mProjectApplicationCache;

    @Inject
    TestModelRepository mTestModelRepository;

    @Inject
    public HomeViewModel() {

    }

    public LiveData<List<TestModel>> getTestModels() {
        return mTestModelRepository.getTestModels();
    }

    public void insertTestModel(TestModel testModel) {
        mTestModelRepository.insertTestModel(testModel);
    }

    public void deleteTestModel(TestModel testModel) {
        mTestModelRepository.deleteTestModel(testModel);
    }
}
