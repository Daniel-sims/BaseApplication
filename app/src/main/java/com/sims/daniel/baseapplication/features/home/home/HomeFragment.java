package com.sims.daniel.baseapplication.features.home.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.databinding.FragmentHomeBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseFragment;
import com.sims.daniel.baseapplication.features.home.HomeViewModel;
import com.sims.daniel.baseapplication.features.home.interfaces.IHomeActivityCallback;

import java.lang.ref.WeakReference;

import timber.log.Timber;

public class HomeFragment extends BaseFragment<HomeViewModel> {

    private FragmentHomeBinding mFragmentHomeBinding;
    private WeakReference<IHomeActivityCallback> mHomeActivityCallback;

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

        return mFragmentHomeBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof IHomeActivityCallback) {
            mHomeActivityCallback = new WeakReference<>((IHomeActivityCallback) context);
        } else {
            throw new RuntimeException("Activity does not implement - IHomeActivityCallback");
        }
    }

    private IHomeActivityCallback getActivityCallback() {
        IHomeActivityCallback homeActivityCallback = mHomeActivityCallback.get();
        if(homeActivityCallback != null) {
            return homeActivityCallback;
        }

        Timber.d("HomeActivityCallback was null");
        return null;
    }
}
