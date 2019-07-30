package com.noisyz.pincodetest.di.module;

import com.noisyz.pincodetest.data.presenterfactory.PresenterFactory;
import com.noisyz.pincodetest.di.Scopes;
import com.noisyz.pincodetest.modules.lockscreen.LockscreenContract;

import dagger.Module;
import dagger.Provides;

@Module
@Scopes.FragmentScope
public class LockscreenModule {

    @Provides
    @Scopes.FragmentScope
    LockscreenContract.Presenter providePresenter(PresenterFactory presenterFactory) {
        return presenterFactory.getPresenter(LockscreenContract.Presenter.class);
    }

}
