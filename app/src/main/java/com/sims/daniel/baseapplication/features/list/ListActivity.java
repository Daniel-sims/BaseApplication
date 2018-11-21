package com.sims.daniel.baseapplication.features.list;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.features.application.base.BaseActivity;
import com.sims.daniel.baseapplication.features.list.interfaces.IListActivityCallback;

public class ListActivity extends BaseActivity implements IListActivityCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (savedInstanceState == null) {
            swapFragment(ListFragment.newInstance(), false, false);
        }
    }

    @Override
    protected int getContainerViewId() {
        return R.id.activity_list_fragment_container;
    }

}