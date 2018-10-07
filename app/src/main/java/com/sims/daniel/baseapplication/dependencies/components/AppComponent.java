package com.sims.daniel.baseapplication.dependencies.components;

import com.sims.daniel.baseapplication.dependencies.modules.AppModule;
import com.sims.daniel.baseapplication.dependencies.modules.DataProviderModule;
import com.sims.daniel.baseapplication.dependencies.modules.NetworkModule;
import com.sims.daniel.baseapplication.dependencies.modules.ViewModelModule;
import com.sims.daniel.baseapplication.features.home.about.AboutFragment;
import com.sims.daniel.baseapplication.features.home.home.HomeFragment;
import com.sims.daniel.baseapplication.features.styles.StyleSheetFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        ViewModelModule.class,
        DataProviderModule.class})
public interface AppComponent {

    /*
        Home feature
     */
    void inject(HomeFragment homeFragment);

    void inject(AboutFragment aboutFragment);

    /*
        Style Sheet feature
     */
    void inject(StyleSheetFragment styleSheetFragment);
}
