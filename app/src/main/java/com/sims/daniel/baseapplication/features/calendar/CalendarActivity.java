package com.sims.daniel.baseapplication.features.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.features.application.base.BaseActivity;
import com.sims.daniel.baseapplication.features.calendar.interfaces.ICalendarActivityCallback;
import com.sims.daniel.baseapplication.features.home.HomeActivity;

public class CalendarActivity extends BaseActivity implements ICalendarActivityCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        if (savedInstanceState == null) {
            swapFragment(CalendarFragment.newInstance(), false, false);
        }
    }

    @Override
    protected int getContainerViewId() {
        return R.id.activity_calendar_fragment_container;
    }


    @Override
    public void goToHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}