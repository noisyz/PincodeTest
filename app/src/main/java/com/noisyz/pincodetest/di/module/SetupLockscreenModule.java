package com.noisyz.pincodetest.di.module;

import com.noisyz.pincodetest.data.presenterfactory.PresenterFactory;
import com.noisyz.pincodetest.di.Scopes;
import com.noisyz.pincodetest.modules.lockscreen.SetupLockscreenContract;

import dagger.Module;
import dagger.Provides;

@Module
@Scopes.FragmentScope
public class SetupLockscreenModule {

    @Provides
    @Scopes.FragmentScope
    SetupLockscreenContract.Presenter providePresenter(PresenterFactory presenterFactory) {
        return presenterFactory.getPresenter(SetupLockscreenContract.Presenter.class);
    }

}
