package com.noisyz.pincodetest.modules.lockscreen.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.noisyz.pincodetest.App;
import com.noisyz.pincodetest.R;
import com.noisyz.pincodetest.di.component.DaggerSetupLockscreenComponent;
import com.noisyz.pincodetest.di.module.SetupLockscreenModule;
import com.noisyz.pincodetest.modules.lockscreen.SetupLockscreenContract;

import javax.inject.Inject;

public class SetupLockscreenFragment extends BaseLockscreenFragment implements SetupLockscreenContract.View {

    @Inject
    SetupLockscreenContract.Presenter presenter;

    private TextView lockscreenAction;

    public static SetupLockscreenFragment newInstance() {
        return new SetupLockscreenFragment();
    }

    public SetupLockscreenFragment() {
    }

    @Override
    protected void injectComponent() {
        DaggerSetupLockscreenComponent.builder().appComponent(App.getInstance().getAppComponent())
                .setupLockscreenModule(new SetupLockscreenModule())
                .build().inject(this);

        presenter.attachView(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lockscreenAction = view.findViewById(R.id.pin_action);
        lockscreenAction.setOnClickListener(this);
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
    public void onClick(View v) {
        if (v.getId() == R.id.pin_action) {
            presenter.performAction();
        } else {
            super.onClick(v);
        }
    }

    @Override
    public void updateActionText(int stringId) {
        lockscreenAction.setText(stringId);
    }

    @Override
    public void releasePresenter() {
        presenter.release();
    }

}
