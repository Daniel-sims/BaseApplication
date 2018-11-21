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
import com.sims.daniel.baseapplication.features.application.base.BaseCallbackFragment;
import com.sims.daniel.baseapplication.features.styles.interfaces.IStyleSheetActivityCallback;
import com.sims.daniel.baseapplication.utils.Utilities;

public class StyleSheetFragment extends BaseCallbackFragment<StyleSheetViewModel, IStyleSheetActivityCallback> {

    private FragmentStyleSheetBinding mFragmentStyleSheetBinding;

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
        initActivityCallback(IStyleSheetActivityCallback.class);

        initToolbar();

        return mFragmentStyleSheetBinding.getRoot();
    }

    private void initToolbar() {
        Context context = getContext();
        if (context != null) {
            mFragmentStyleSheetBinding.fragmentStyleSheetToolbar.setNavigationIcon(Utilities.getAttributeTintedDrawable(
                    getContext(),
                    R.attr.NavigationUpArrow,
                    R.attr.StyleSheetFragmentNavigationIconColor));

            mFragmentStyleSheetBinding.fragmentStyleSheetToolbar.setNavigationOnClickListener(view -> onBackPressed());
        }
    }
}