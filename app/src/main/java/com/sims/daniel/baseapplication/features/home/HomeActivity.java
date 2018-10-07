package com.sims.daniel.baseapplication.features.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.features.application.base.BaseActivity;
import com.sims.daniel.baseapplication.features.calendar.CalendarActivity;
import com.sims.daniel.baseapplication.features.home.about.AboutFragment;
import com.sims.daniel.baseapplication.features.home.home.HomeFragment;
import com.sims.daniel.baseapplication.features.home.interfaces.IHomeActivityCallback;
import com.sims.daniel.baseapplication.features.styles.StyleSheetActivity;

public class HomeActivity extends BaseActivity implements IHomeActivityCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            swapFragment(HomeFragment.newInstance(), false, false);
        }
    }

    @Override
    protected int getContainerViewId() {
        return R.id.activity_home_fragment_container;
    }

    @Override
    public void goToCalendarActivity() {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToStyleSheetActivity() {
        Intent intent = new Intent(this, StyleSheetActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToAboutFragment() {
        swapFragment(AboutFragment.newInstance(), true, true);
    }
}