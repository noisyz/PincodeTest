package com.noisyz.pincodetest.modules.lockscreen.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.noisyz.pincodetest.modules.common.base.FragmentContainerActivity;

public class LockScreenActivity extends FragmentContainerActivity {

    public static final String EXTRA_ONLY_SETUP = "EXTRA_ONLY_SETUP";

    public static void showSetupLockscreen(Context context) {
        show(context, true);
    }

    public static void showLockscreen(Context context) {
        show(context, false);
    }

    private static void show(Context context, boolean onlySetup) {
        Intent intent = new Intent(context, LockScreenActivity.class);
        intent.putExtra(EXTRA_ONLY_SETUP, onlySetup);
        context.startActivity(intent);
    }

    @Override
    protected void doOnCreate(Bundle savedInstanceState) {
        super.doOnCreate(savedInstanceState);
        getSupportActionBar().hide();
    }

    @Override
    protected Fragment initFragment() {
        return getIntent().getBooleanExtra(EXTRA_ONLY_SETUP, true)
                ? SetupLockscreenFragment.newInstance() : LockscreenFragment.newInstance();
    }
}
