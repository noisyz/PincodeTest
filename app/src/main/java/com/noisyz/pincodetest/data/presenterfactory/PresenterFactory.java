package com.noisyz.pincodetest.data.presenterfactory;

import com.noisyz.pincodetest.data.IStorageManager;
import com.noisyz.pincodetest.di.Scopes;
import com.noisyz.pincodetest.modules.lockscreen.LockscreenContract;
import com.noisyz.pincodetest.modules.lockscreen.SetupLockscreenContract;
import com.noisyz.pincodetest.modules.lockscreen.presenter.LockscreenPresenter;
import com.noisyz.pincodetest.modules.lockscreen.presenter.SetupLockscreenPresenter;

import javax.inject.Inject;

public class PresenterFactory {

    private IStorageManager storageManager;

    @Inject
    public PresenterFactory(@Scopes.ApplicationScope IStorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public <T> T getPresenter(Class<T> presenterClass) {
        Object presenter = null;
        if (SetupLockscreenContract.Presenter.class.equals(presenterClass)) {
            presenter = new SetupLockscreenPresenter(storageManager);
        }
        if (LockscreenContract.Presenter.class.equals(presenterClass)) {
            presenter = new LockscreenPresenter(storageManager);
        }

        if (presenter != null) {
            return (T) presenter;
        } else {
            throw new IllegalArgumentException("Current presenter interface does not have a realization, class = "
                    + presenterClass.toString());
        }
    }

}
