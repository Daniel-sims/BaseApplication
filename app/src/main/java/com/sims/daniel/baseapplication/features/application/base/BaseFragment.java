package com.sims.daniel.baseapplication.features.application.base;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.sims.daniel.baseapplication.dependencies.components.AppComponent;
import com.sims.daniel.baseapplication.factories.ViewModelFactory;
import com.sims.daniel.baseapplication.features.application.ProjectApplication;

import javax.inject.Inject;

public abstract class BaseFragment<T extends ViewModel> extends Fragment {

    protected @Inject
    ViewModelFactory mViewModelFactory;

    private T mViewModel;

    protected void initViewModel(Class<T> cls) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new RuntimeException("Error: initViewModel() - Cannot create view model with null Activity.");
        }

        if (mViewModelFactory != null) {
            mViewModel = ViewModelProviders.of(activity, mViewModelFactory).get(cls);
        } else {
            throw new RuntimeException("Error: initViewModel() - Fragment not injected using dagger. Be sure to call "
                    + "getAppComponent().inject(Fragment.this) before initialising the view model.");
        }
    }

    protected AppComponent getAppComponent() {
        Activity activity = getActivity();
        if (activity != null) {
            Application app = activity.getApplication();
            if (app instanceof ProjectApplication) {
                return ((ProjectApplication) app).getAppComponent();
            }
        }

        throw new RuntimeException("Error: getAppComponent() - Could not locate AppComponent.");
    }

    protected T getViewModel() {
        if (mViewModel != null) {
            return mViewModel;
        } else {
            throw new RuntimeException("Error: getViewModel() - ViewModel not initialised please called initViewModel<T>.");
        }
    }

    protected void finishActivity() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    protected void onBackPressed() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
