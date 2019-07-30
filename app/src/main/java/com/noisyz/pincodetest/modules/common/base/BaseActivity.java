package com.noisyz.pincodetest.modules.common.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayoutId());
        doOnCreate(savedInstanceState);
    }

    protected abstract void doOnCreate(Bundle savedInstanceState);


    protected abstract int getContentLayoutId();
}