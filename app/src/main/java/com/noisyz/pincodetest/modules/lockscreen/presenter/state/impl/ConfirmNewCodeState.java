package com.noisyz.pincodetest.modules.lockscreen.presenter.state.impl;

import com.noisyz.pincodetest.R;
import com.noisyz.pincodetest.modules.lockscreen.presenter.state.abs.LockscreenState;

public class ConfirmNewCodeState extends LockscreenState {

    public static final int CODE = 4;

    public ConfirmNewCodeState(LockscreenState.Callback callback) {
        super(callback);
    }

    @Override
    public int getStateTitle() {
        return R.string.confirm_pin;
    }

    @Override
    public int getStateActionText() {
        return R.string.cancel;
    }

    @Override
    public int getStateCode() {
        return CODE;
    }
}
