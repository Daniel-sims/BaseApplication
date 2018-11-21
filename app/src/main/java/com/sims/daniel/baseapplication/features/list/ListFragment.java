package com.sims.daniel.baseapplication.features.list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.databinding.FragmentListBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseCallbackFragment;
import com.sims.daniel.baseapplication.features.list.interfaces.IListActivityCallback;
import com.sims.daniel.baseapplication.utils.Utilities;

public class ListFragment extends BaseCallbackFragment<ListViewModel, IListActivityCallback> {

    private FragmentListBinding mFragmentListBinding;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_list, container, false);

        getAppComponent().inject(this);

        initViewModel(ListViewModel.class);
        initActivityCallback(IListActivityCallback.class);

        initToolbar();

        return mFragmentListBinding.getRoot();
    }

    private void initToolbar() {
        Context context = getContext();
        if (context != null) {
            mFragmentListBinding.fragmentListToolbar.setNavigationIcon(Utilities.getAttributeTintedDrawable(
                    getContext(),
                    R.attr.NavigationUpArrow,
                    R.attr.ListFragmentNavigationIconColor));

            mFragmentListBinding.fragmentListToolbar.setNavigationOnClickListener(view -> onBackPressed());
        }
    }


}
