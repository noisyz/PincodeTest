package com.noisyz.pincodetest.modules.common.view;


public interface ItemView<T> extends BackgroundJobView, BasePresentableView{

    void onItemLoaded(T t);

    void requestItem();

}
