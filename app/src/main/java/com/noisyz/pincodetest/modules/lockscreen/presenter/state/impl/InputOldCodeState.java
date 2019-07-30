package com.noisyz.pincodetest.modules.lockscreen.presenter.state.impl;

import com.noisyz.pincodetest.R;
import com.noisyz.pincodetest.modules.lockscreen.presenter.state.abs.LockscreenState;

public class InputOldCodeState extends LockscreenState {

    public static final int CODE = 2;

    public InputOldCodeState(Callback callback) {
        super(callback);
    }

    @Override
    public int getStateTitle() {
        return R.string.enter_old_pin;
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
