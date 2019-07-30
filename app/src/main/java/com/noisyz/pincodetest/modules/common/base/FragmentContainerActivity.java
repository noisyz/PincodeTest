package com.noisyz.pincodetest.modules.common.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.noisyz.pincodetest.R;

public abstract class FragmentContainerActivity extends BaseActivity {

    protected abstract Fragment initFragment();

    @Override
    protected void doOnCreate(Bundle savedInstanceState) {
        Fragment fragment = initFragment();
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.container;
    }
}
