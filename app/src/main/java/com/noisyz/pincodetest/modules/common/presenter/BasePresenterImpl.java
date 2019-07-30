package com.noisyz.pincodetest.modules.common.presenter;


import com.noisyz.pincodetest.data.IStorageManager;
import com.noisyz.pincodetest.modules.common.BaseErrorCallback;
import com.noisyz.pincodetest.modules.common.view.BasePresentableView;

public class BasePresenterImpl<T extends BasePresentableView> implements BasePresenter<T>, BaseErrorCallback {

    private IStorageManager storageManager;

    private T t;

    public BasePresenterImpl(IStorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public IStorageManager getStorageManager() {
        return storageManager;
    }

    protected T getView() {
        return t;
    }

    @Override
    public void attachView(T t) {
        this.t = t;
    }

    @Override
    public void release() {
        t = null;
    }

    @Override
    public void onError(int errorCode, String errorMessage) {
        if (t != null) {
            t.showMessage(errorMessage);
        }
    }
}
