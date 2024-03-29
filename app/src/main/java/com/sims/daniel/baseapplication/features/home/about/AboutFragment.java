package com.sims.daniel.baseapplication.features.home.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.databinding.FragmentAboutBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseCallbackFragment;
import com.sims.daniel.baseapplication.features.home.HomeViewModel;
import com.sims.daniel.baseapplication.features.home.interfaces.IHomeActivityCallback;

public class AboutFragment extends BaseCallbackFragment<HomeViewModel, IHomeActivityCallback> {

    private FragmentAboutBinding mFragmentAboutBinding;

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentAboutBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_about, container, false);

        getAppComponent().inject(this);

        initViewModel(HomeViewModel.class);
        initActivityCallback(IHomeActivityCallback.class);
        
        return mFragmentAboutBinding.getRoot();
    }
}
