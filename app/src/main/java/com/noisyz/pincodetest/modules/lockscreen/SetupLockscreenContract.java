package com.noisyz.pincodetest.modules.lockscreen;


import android.support.annotation.StringRes;

public interface SetupLockscreenContract {

    interface View extends BaseLockscreenContract.View {

        void updateActionText(@StringRes int stringId);

    }

    interface Presenter extends BaseLockscreenContract.Presenter<View>{

        void performAction();

    }
}
