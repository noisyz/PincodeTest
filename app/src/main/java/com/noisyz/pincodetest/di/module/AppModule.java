package com.noisyz.pincodetest.di.module;

import com.noisyz.pincodetest.App;
import com.noisyz.pincodetest.data.IStorageManager;
import com.noisyz.pincodetest.data.SharedManager;
import com.noisyz.pincodetest.data.StorageManager;
import com.noisyz.pincodetest.di.Scopes;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Scopes.ApplicationScope
    App provideContext() {
        return app;
    }

    @Provides
    @Scopes.ApplicationScope
    IStorageManager provideStorageManager(SharedManager sharedManager) {
        return new StorageManager(sharedManager);
    }


    @Provides
    @Scopes.ApplicationScope
    SharedManager provideSharedManager() {
        return new SharedManager(app);
    }
}
