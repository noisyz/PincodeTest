package com.noisyz.pincodetest.modules.common.presenter;


import com.noisyz.pincodetest.modules.common.view.BasePresentableView;

public interface BasePresenter<T extends BasePresentableView> {

    void attachView(T t);

    void release();
}
