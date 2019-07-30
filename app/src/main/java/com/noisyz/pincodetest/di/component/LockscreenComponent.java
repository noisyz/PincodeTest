package com.noisyz.pincodetest.di.component;

import com.noisyz.pincodetest.di.Scopes;
import com.noisyz.pincodetest.di.module.LockscreenModule;
import com.noisyz.pincodetest.modules.lockscreen.ui.LockscreenFragment;

import dagger.Component;

@Scopes.FragmentScope
@Component(dependencies = AppComponent.class, modules = LockscreenModule.class)
public interface LockscreenComponent {

    void inject(LockscreenFragment fragment);

}
