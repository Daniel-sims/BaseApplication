package com.sims.daniel.baseapplication.data.repositories;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sims.daniel.baseapplication.data.daos.TestModelDao;
import com.sims.daniel.baseapplication.data.models.TestModel;

import java.util.List;

public class TestModelRepository {

    private final TestModelDao mTestModelDao;

    public TestModelRepository(TestModelDao testModelDao) {
        mTestModelDao = testModelDao;
    }

    public LiveData<List<TestModel>> getTestModels() {
        return mTestModelDao.getAll();
    }

    public void insertTestModel(@NonNull TestModel testModel) {
        new Thread(() -> mTestModelDao.insert(testModel)).start();
    }

    public void insertTestModelList(@NonNull List<TestModel> testModelList) {
        new Thread(() -> mTestModelDao.insertAll(testModelList)).start();
    }

    public void updateTestModel(@NonNull TestModel testModel) {
        new Thread(() -> mTestModelDao.update(testModel)).start();
    }

    public void deleteTestModel(@NonNull TestModel testModel) {
        new Thread(() -> mTestModelDao.delete(testModel)).start();
    }
}
