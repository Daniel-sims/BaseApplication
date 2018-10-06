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

import java.util.Set;

public abstract class BaseActivity extends AppCompatActivity {

    @AnimRes
    private static final int ENTER_ANIMATION = R.anim.slide_in_from_bottom;
    @AnimRes
    private static final int EXIT_ANIMATION = R.anim.fade_out;
    @AnimRes
    private static final int POP_EXIT_ANIMATION = R.anim.slide_out_to_bottom;
    @AnimRes
    private static final int POP_ENTER_ANIMATION = R.anim.fade_in;

    protected abstract int getContainerViewId();

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

    private boolean areBundlesEqual(@Nullable Bundle args1, @Nullable Bundle args2) {
        if (args1 == null && args2 == null) {
            return true;
        } else if (args1 == null) {
            return false;
        } else if (args2 == null) {
            return false;
        }

        if (args1.size() != args2.size()) {
            return false;
        }

        Set<String> setOne = args1.keySet();
        Object valueOne;
        Object valueTwo;

        for (String key : setOne) {
            valueOne = args1.get(key);
            valueTwo = args2.get(key);
            if (valueOne instanceof Bundle && valueTwo instanceof Bundle &&
                    !areBundlesEqual((Bundle) valueOne, (Bundle) valueTwo)) {
                return false;
            } else if (valueOne == null) {
                if (valueTwo != null || !args2.containsKey(key)) {
                    return false;
                }
            } else if (!valueOne.equals(valueTwo)) {
                return false;
            }
        }

        return true;
    }

    @NonNull
    protected int[] getAnimationIntArray() {
        return new int[]{ENTER_ANIMATION, EXIT_ANIMATION, POP_ENTER_ANIMATION, POP_EXIT_ANIMATION};
    }
}