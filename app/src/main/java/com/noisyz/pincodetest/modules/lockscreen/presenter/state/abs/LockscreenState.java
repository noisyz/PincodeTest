package com.noisyz.pincodetest.modules.lockscreen.presenter.state.abs;

import android.support.annotation.StringRes;

public abstract class LockscreenState {

    private static final int INPUT_SIZE = 4;

    private Callback callback;
    private StringBuilder pincode;

    public LockscreenState(Callback callback) {
        this.callback = callback;
        init();
    }

    public void init() {
        pincode = new StringBuilder();
    }

    public void input(String input) {
        if (pincode.length() < INPUT_SIZE) {
            pincode.append(input);

            if (callback != null) {
                callback.updateProgress(pincode.length());
                if (pincode.length() >= INPUT_SIZE) {
                    callback.moveToNext(this);
                }
            }
        }
    }

    public void backspace() {
        if (pincode.length() > 0) {
            pincode.setLength(pincode.length() - 1);
            if (callback != null) {
                callback.updateProgress(pincode.length());
            }
        }
    }

    public String getInput() {
        return pincode.toString();
    }

    @StringRes
    public abstract int getStateTitle();

    @StringRes
    public abstract int getStateActionText();

    public abstract int getStateCode();

    public interface Callback {

        void moveToNext(LockscreenState state);

        void updateProgress(int progress);

    }

}
