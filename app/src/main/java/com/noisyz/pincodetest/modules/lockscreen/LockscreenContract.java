package com.noisyz.pincodetest.modules.lockscreen;

public interface LockscreenContract {

    interface View extends BaseLockscreenContract.View {

        void updateFingerprintAvailability(boolean available);

    }

    interface Presenter extends BaseLockscreenContract.Presenter<View> {

    }
}
