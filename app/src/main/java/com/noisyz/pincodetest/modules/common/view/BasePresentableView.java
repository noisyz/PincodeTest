package com.noisyz.pincodetest.modules.common.view;

import android.content.Context;
import android.support.annotation.StringRes;

public interface BasePresentableView {

    void releasePresenter();

    void showMessage(String message);

    void showMessage(@StringRes int messId);

    void dismiss();

    Context getContext();
}
