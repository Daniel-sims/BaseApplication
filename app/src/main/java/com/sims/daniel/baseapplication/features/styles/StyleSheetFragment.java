package com.sims.daniel.baseapplication.features.styles;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.databinding.FragmentStyleSheetBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseFragment;
import com.sims.daniel.baseapplication.features.styles.interfaces.IStyleSheetActivityCallback;
import com.sims.daniel.baseapplication.utils.Utilities;

import java.lang.ref.WeakReference;

import timber.log.Timber;

public class StyleSheetFragment extends BaseFragment<StyleSheetViewModel> {

    private FragmentStyleSheetBinding mFragmentStyleSheetBinding;
    private WeakReference<IStyleSheetActivityCallback> mStyleSheetActivityCallback;

    public static StyleSheetFragment newInstance() {
        return new StyleSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentStyleSheetBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_style_sheet, container, false);

        getAppComponent().inject(this);
        initViewModel(StyleSheetViewModel.class);

        initToolbar();

        return mFragmentStyleSheetBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof IStyleSheetActivityCallback) {
            mStyleSheetActivityCallback = new WeakReference<>((IStyleSheetActivityCallback) context);
        } else {
            throw new RuntimeException("Error: Activity does not implement - IStyleSheetActivityCallback.");
        }
    }

    private void initToolbar() {
        Context context = getContext();
        if (context != null) {
            mFragmentStyleSheetBinding.fragmentStyleSheetToolbar.setNavigationIcon(Utilities.getAttributeTintedDrawable(
                    getContext(),
                    R.attr.NavigationUpArrow,
                    R.attr.StyleSheetNavigationIconColor));

            mFragmentStyleSheetBinding.fragmentStyleSheetToolbar.setNavigationOnClickListener(view -> onBackPressed());
        }

    }

    private IStyleSheetActivityCallback getActivityCallback() {
        IStyleSheetActivityCallback styleSheetActivityCallback = mStyleSheetActivityCallback.get();
        if (styleSheetActivityCallback != null) {
            return styleSheetActivityCallback;
        } else {
            Timber.d("StyleSheetActivityCallback was null.");
            return null;
        }
    }
}