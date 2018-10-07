package com.sims.daniel.baseapplication.features.application.base;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sims.daniel.baseapplication.R;

import java.util.Objects;

public abstract class BaseActivity extends AppCompatActivity {

    @AnimRes
    private static final int ENTER_ANIMATION = R.anim.slide_in_from_bottom;
    @AnimRes
    private static final int EXIT_ANIMATION = R.anim.fade_out;
    @AnimRes
    private static final int POP_EXIT_ANIMATION = R.anim.slide_out_to_bottom;
    @AnimRes
    private static final int POP_ENTER_ANIMATION = R.anim.fade_in;

    @NonNull
    protected int[] getAnimationIntArray() {
        return new int[]{ENTER_ANIMATION, EXIT_ANIMATION, POP_ENTER_ANIMATION, POP_EXIT_ANIMATION};
    }

    public interface OnBackPressedListener {
        boolean onBackPressed();
    }

    @Override
    public void onBackPressed() {
        boolean handled = false;

        Fragment fragment = getSupportFragmentManager().findFragmentById(getContainerViewId());
        if (fragment != null && fragment instanceof OnBackPressedListener) {
            handled = ((OnBackPressedListener) fragment).onBackPressed();
        }

        if (!handled) {
            super.onBackPressed();
        }
    }

    protected void swapFragment(@NonNull Fragment fragment, boolean addToBackStack, boolean animate) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.findFragmentById(getContainerViewId());
        if (currentFragment != null && currentFragment.getClass().equals(fragment.getClass())) {
            // Check the fragment arguments, if the arguments are the same then yield
            if (areBundlesEqual(currentFragment.getArguments(), fragment.getArguments())) {
                return;
            }
        }

        if (animate) {
            int[] anims = getAnimationIntArray();
            fragmentTransaction.setCustomAnimations(anims[0], anims[1], anims[2], anims[3]);
        }

        fragmentTransaction.replace(getContainerViewId(), fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    private boolean areBundlesEqual(@Nullable Bundle extras, @Nullable Bundle newExtras) {
        if (extras == null || newExtras == null) {
            return extras == newExtras;
        }
        if (extras.size() != newExtras.size()) {
            return false;
        }
        for (String key : extras.keySet()) {
            if (key != null) {
                final Object value = extras.get(key);
                final Object newValue = newExtras.get(key);
                if (!Objects.equals(value, newValue)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected abstract int getContainerViewId();
}