package com.noisyz.pincodetest.modules.lockscreen.presenter;

import android.util.Log;

import com.noisyz.pincodetest.R;
import com.noisyz.pincodetest.data.FingerprintManager;
import com.noisyz.pincodetest.data.IStorageManager;
import com.noisyz.pincodetest.modules.common.presenter.BasePresenterImpl;
import com.noisyz.pincodetest.modules.lockscreen.LockscreenContract;

import io.reactivex.disposables.Disposable;

public class LockscreenPresenter extends BasePresenterImpl<LockscreenContract.View> implements LockscreenContract.Presenter, FingerprintManager.Callback {

    private static final int INPUT_SIZE = 4;

    private Disposable fingerprintScanner;
    private StringBuilder input;

    public LockscreenPresenter(IStorageManager storageManager) {
        super(storageManager);
    }

    @Override
    public void attachView(LockscreenContract.View view) {
        super.attachView(view);

        initLockscreen(view);
    }

    private void initLockscreen(LockscreenContract.View view) {
        input = new StringBuilder();
        view.updateProgress(0);
        view.updateTitle(R.string.enter_pin);

        if (FingerprintManager.isFingerprintAvailable(getView().getContext())) {
            fingerprintScanner = FingerprintManager.subscribeForFingerprintAuth(view.getContext(), this);
            view.updateFingerprintAvailability(true);
            view.updateTitle(R.string.enter_pin_or_use_touch_id);
        }
    }

    @Override
    public void input(String input) {
        if (this.input.length() < INPUT_SIZE) {
            this.input.append(input);
            getView().updateProgress(this.input.length());

            if (this.input.length() >= INPUT_SIZE) {
                input(null);
            }
        } else if (this.input.toString().equals(getStorageManager().getPincode())) {
            getView().finish();
        } else {
            this.input = new StringBuilder();
            getView().updateProgress(0);
            getView().showMessage(R.string.pin_error);
        }
    }

    @Override
    public void backspace() {
        if (input.length() > 0) {
            input.setLength(input.length() - 1);
            getView().updateProgress(input.length());
        }
    }


    @Override
    public void onFingerPrintAuth() {
        getView().finish();
    }

    @Override
    public void release() {
        super.release();
        fingerprintScanner.dispose();
    }

    @Override
    public void onErrorMessage(String message) {
        onError(0, message);
    }
}