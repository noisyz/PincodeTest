package com.noisyz.pincodetest.modules.common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noisyz.pincodetest.R;

public abstract class DefaultFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ViewGroup contentContainer =  view.findViewById(R.id.content_container);
        if (contentContainer != null) {
            contentContainer.addView(inflater.inflate(getContentLayout(), null));
        }
        return view;
    }

    @LayoutRes
    protected int getLayoutId() {
        return R.layout.fragment_item;
    }

    @LayoutRes
    protected abstract int getContentLayout();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
    }

    protected abstract void initUI(View view);
}
