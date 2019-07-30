package com.noisyz.pincodetest.di.component;

import com.noisyz.pincodetest.data.IStorageManager;
import com.noisyz.pincodetest.di.Scopes;
import com.noisyz.pincodetest.di.module.AppModule;

import dagger.Component;

@Component(modules = AppModule.class)
@Scopes.ApplicationScope
public interface AppComponent {

    IStorageManager getStorageManager();

}