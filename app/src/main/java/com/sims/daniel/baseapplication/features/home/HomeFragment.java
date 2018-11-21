package com.sims.daniel.baseapplication.features.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.databinding.FragmentHomeBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseCallbackFragment;
import com.sims.daniel.baseapplication.features.home.interfaces.IHomeActivityCallback;

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

        initOnClick();

        return mFragmentHomeBinding.getRoot();
    }

    private void initOnClick() {
        mFragmentHomeBinding.fragmentHomeGoToStyleSheetFragmentButton.setOnClickListener(view -> {
            IHomeActivityCallback homeActivityCallback = getActivityCallback();
            if (homeActivityCallback != null) {
                homeActivityCallback.goToStyleSheetActivity();
            }
        });

        mFragmentHomeBinding.fragmentHomeGoToListActivityButton.setOnClickListener(view -> {
            IHomeActivityCallback homeActivityCallback = getActivityCallback();
            if (homeActivityCallback != null) {
                homeActivityCallback.goToListActivity();
            }
        });
    }
}
