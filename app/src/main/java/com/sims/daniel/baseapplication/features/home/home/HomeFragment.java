package com.sims.daniel.baseapplication.features.home.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.data.models.TestModel;
import com.sims.daniel.baseapplication.databinding.FragmentHomeBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseCallbackFragment;
import com.sims.daniel.baseapplication.features.home.HomeViewModel;
import com.sims.daniel.baseapplication.features.home.interfaces.IHomeActivityCallback;
import com.sims.daniel.baseapplication.utils.Utilities;

public class HomeFragment extends BaseCallbackFragment<HomeViewModel, IHomeActivityCallback> {

    private FragmentHomeBinding mFragmentHomeBinding;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentHomeBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false);

        getAppComponent().inject(this);

        initViewModel(HomeViewModel.class);
        initActivityCallback(IHomeActivityCallback.class);

        initMockData();

        initOnClick();
        initObservers();

        return mFragmentHomeBinding.getRoot();
    }

    private void initOnClick() {
        mFragmentHomeBinding.fragmentHomeGoToAboutUsButton.setOnClickListener(view -> {
            IHomeActivityCallback homeActivityCallback = getActivityCallback();
            if (homeActivityCallback != null) {
                homeActivityCallback.goToAboutFragment();
            }
        });

        mFragmentHomeBinding.fragmentHomeGoToStyleSheetButton.setOnClickListener(view -> {
            IHomeActivityCallback homeActivityCallback = getActivityCallback();
            if (homeActivityCallback != null) {
                homeActivityCallback.goToStyleSheetActivity();
            }
        });
    }

    private void initObservers() {
        getViewModel().getTestModels().observe(getViewLifecycleOwner(), testModels -> {
            if (!Utilities.isNullOrEmpty(testModels)) {
                TestModel firstTestModel = testModels.get(0);

                if (firstTestModel != null) {
                    Toast.makeText(getContext(), firstTestModel.getTestModelName(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initMockData() {
        TestModel testModel = new TestModel();
        testModel.setTestModelName("This is a test!");
        testModel.setCounter(1);

        getViewModel().insertTestModel(testModel);
    }
}
