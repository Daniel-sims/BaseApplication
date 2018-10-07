package com.sims.daniel.baseapplication.features.calendar;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.databinding.FragmentCalendarBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseFragment;
import com.sims.daniel.baseapplication.features.calendar.interfaces.ICalendarActivityCallback;

import java.lang.ref.WeakReference;

import timber.log.Timber;

public class CalendarFragment extends BaseFragment<CalendarViewModel> {

    private FragmentCalendarBinding mFragmentCalendarBinding;
    private WeakReference<ICalendarActivityCallback> mCalendarActivityCallback;

    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentCalendarBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_calendar, container, false);

        getAppComponent().inject(this);
        initViewModel(CalendarViewModel.class);

        return mFragmentCalendarBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof ICalendarActivityCallback) {
            mCalendarActivityCallback = new WeakReference<>((ICalendarActivityCallback) context);
        } else {
            throw new RuntimeException("Activity does not implement - ICalendarActivityCallback");
        }
    }

    private ICalendarActivityCallback getActivityCallback() {
        ICalendarActivityCallback calendarActivityCallback = mCalendarActivityCallback.get();
        if(calendarActivityCallback != null) {
            return calendarActivityCallback;
        } else {
            Timber.d("CalendarActivityCallback was null.");
            return null;
        }
    }
}
