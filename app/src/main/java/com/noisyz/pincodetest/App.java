package com.noisyz.pincodetest;

import android.app.Application;

import com.noisyz.pincodetest.di.component.AppComponent;
import com.noisyz.pincodetest.di.component.DaggerAppComponent;
import com.noisyz.pincodetest.di.module.AppModule;

public class App extends Application {

    private AppComponent appComponent;
    private static App app;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = buildComponent();
    }

    public static App getInstance() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
