package com.noisyz.pincodetest.modules.lockscreen;

import android.support.annotation.StringRes;

import com.noisyz.pincodetest.modules.common.presenter.BasePresenter;
import com.noisyz.pincodetest.modules.common.view.BasePresentableView;


public interface BaseLockscreenContract {

    interface View extends BasePresentableView {

        void updateProgress(int progress);

        void updateTitle(@StringRes int stringId);

        void finish();
    }

    interface Presenter<T extends View> extends BasePresenter<T> {

        void input(String input);

        void backspace();

    }
}
