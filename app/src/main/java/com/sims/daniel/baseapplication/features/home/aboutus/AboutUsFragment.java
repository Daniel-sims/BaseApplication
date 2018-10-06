package com.sims.daniel.baseapplication.features.home.aboutus;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.databinding.FragmentAboutUsBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseFragment;
import com.sims.daniel.baseapplication.features.home.HomeViewModel;
import com.sims.daniel.baseapplication.features.home.interfaces.IHomeActivityCallback;

public class AboutUsFragment extends BaseFragment<HomeViewModel> {

    private FragmentAboutUsBinding mFragmentAboutUsBinding;
    private IHomeActivityCallback mHomeActivityCallback;

    public static AboutUsFragment newInstance() {
        return new AboutUsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentAboutUsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_about_us, container, false);

        getAppComponent().inject(this);
        initViewModel(HomeViewModel.class);

        return mFragmentAboutUsBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof IHomeActivityCallback) {
            mHomeActivityCallback = (IHomeActivityCallback) context;
        } else {
            throw new RuntimeException("Activity does not implement - IHomeActivityCallback");
        }
    }
}
