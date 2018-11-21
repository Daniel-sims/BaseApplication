package com.sims.daniel.baseapplication.dependencies.modules;

import android.arch.lifecycle.ViewModel;

import com.sims.daniel.baseapplication.features.home.HomeViewModel;
import com.sims.daniel.baseapplication.features.list.ListViewModel;
import com.sims.daniel.baseapplication.features.styles.StyleSheetViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    private @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel homeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(StyleSheetViewModel.class)
    abstract ViewModel bindStyleSheetViewModel(StyleSheetViewModel styleSheetViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel bindListViewModel(ListViewModel listViewModel);
}
