package com.noisyz.pincodetest.di.component;

import com.noisyz.pincodetest.di.Scopes;
import com.noisyz.pincodetest.di.module.SetupLockscreenModule;
import com.noisyz.pincodetest.modules.lockscreen.ui.SetupLockscreenFragment;

import dagger.Component;

@Scopes.FragmentScope
@Component(dependencies = AppComponent.class, modules = SetupLockscreenModule.class)
public interface SetupLockscreenComponent {

    void inject(SetupLockscreenFragment fragment);

}
