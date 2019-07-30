package com.noisyz.pincodetest.modules.common.base;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.noisyz.pincodetest.modules.common.view.BasePresentableView;

public abstract class BaseFragment extends DefaultFragment implements BasePresentableView {

    protected abstract void injectComponent();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        injectComponent();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    @Override
    public void dismiss() {
        getActivity().finish();
    }
}
