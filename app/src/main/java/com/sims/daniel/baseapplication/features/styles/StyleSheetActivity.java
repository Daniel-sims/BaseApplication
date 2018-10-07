package com.sims.daniel.baseapplication.features.styles;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.features.application.base.BaseActivity;
import com.sims.daniel.baseapplication.features.styles.interfaces.IStyleSheetActivityCallback;

public class StyleSheetActivity extends BaseActivity implements IStyleSheetActivityCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_sheet);

        if (savedInstanceState == null) {
            swapFragment(StyleSheetFragment.newInstance(), false, false);
        }
    }

    @Override
    protected int getContainerViewId() {
        return R.id.activity_style_sheet_fragment_container;
    }
}
