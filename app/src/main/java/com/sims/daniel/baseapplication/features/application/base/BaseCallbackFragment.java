package com.sims.daniel.baseapplication.features.application.base;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.lang.ref.WeakReference;

import timber.log.Timber;

/***
 *
 * @param <T> A ViewModel which inherits from ViewModel with an injected constructor.
 * @param <U> An interface of an activity to callback to.
 */
public class BaseCallbackFragment<T extends ViewModel, U> extends BaseFragment<T> {

    private WeakReference<U> mActivityCallback;

    public void initActivityCallback(Class<U> cls) {
        Context context = getContext();

        if(cls.isInstance(context)) {
            mActivityCallback = new WeakReference<>((U) context);
        } else {
            throw new RuntimeException("Error: initCallback() - Could not initialise callback.");
        }
    }

    public U getActivityCallback() {
        U activityCallback = mActivityCallback.get();
        if(activityCallback != null) {
            return activityCallback;
        } else {
            Timber.d("Error: getActivityCallback() - ActivityCallback was null.");
            return null;
        }
    }
}
