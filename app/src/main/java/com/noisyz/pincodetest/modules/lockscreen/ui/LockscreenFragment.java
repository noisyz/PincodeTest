package com.noisyz.pincodetest.modules.lockscreen.ui;

import android.view.View;

import com.noisyz.pincodetest.App;
import com.noisyz.pincodetest.R;
import com.noisyz.pincodetest.di.component.DaggerLockscreenComponent;
import com.noisyz.pincodetest.di.module.LockscreenModule;
import com.noisyz.pincodetest.modules.lockscreen.LockscreenContract;

import javax.inject.Inject;

public class LockscreenFragment extends BaseLockscreenFragment implements LockscreenContract.View {

    @Inject
    LockscreenContract.Presenter presenter;

    public static LockscreenFragment newInstance() {
        return new LockscreenFragment();
    }

    public LockscreenFragment() {
    }

    @Override
    protected void injectComponent() {
        DaggerLockscreenComponent.builder().appComponent(App.getInstance().getAppComponent())
                .lockscreenModule(new LockscreenModule())
                .build().inject(this);

        presenter.attachView(this);
    }

    @Override
    public void updateFingerprintAvailability(boolean available) {
        if (getView() != null) {
            getView().findViewById(R.id.fingerprint).setVisibility(available ? View.VISIBLE : View.INVISIBLE);
        }
    }

    @Override
    protected void input(String value) {
        presenter.input(value);
    }

    @Override
    protected void backspace() {
        presenter.backspace();
    }

    @Override
    public void releasePresenter() {
        presenter.release();
        presenter = null;
    }
}
