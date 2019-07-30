package com.noisyz.pincodetest.modules.lockscreen.ui;

import android.view.View;
import android.widget.TextView;

import com.noisyz.pincodetest.R;
import com.noisyz.pincodetest.modules.common.base.BaseFragment;
import com.noisyz.pincodetest.modules.common.custom.PincodeInputIndicatorView;
import com.noisyz.pincodetest.modules.lockscreen.BaseLockscreenContract;

public abstract class BaseLockscreenFragment extends BaseFragment implements BaseLockscreenContract.View, View.OnClickListener {

    private final int[] inputButtons = new int[]{R.id.pin_0, R.id.pin_1, R.id.pin_2, R.id.pin_3,
            R.id.pin_4, R.id.pin_5, R.id.pin_6, R.id.pin_7, R.id.pin_8, R.id.pin_9};

    private TextView lockscreenTitle;
    private PincodeInputIndicatorView pincodeInputIndicatorView;


    @Override
    protected int getContentLayout() {
        return R.layout.lockscreen_fragment;
    }

    @Override
    protected void initUI(View view) {
        lockscreenTitle = view.findViewById(R.id.lockScreenTitle);
        pincodeInputIndicatorView = view.findViewById(R.id.pincode_input_indicator);
        view.findViewById(R.id.backspace).setOnClickListener(this);

        for (int inputButtonId : inputButtons) {
            view.findViewById(inputButtonId).setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backspace) {
            backspace();
        } else {
            String inputText = ((TextView) v).getText().toString();
            input(inputText);
        }
    }

    @Override
    public void updateTitle(int stringId) {
        lockscreenTitle.setText(stringId);
    }

    @Override
    public void updateProgress(int progress) {
        pincodeInputIndicatorView.setProgress(progress);
    }

    @Override
    public void finish() {
        if (getActivity() != null)
            getActivity().finish();
    }

    protected abstract void input(String value);

    protected abstract void backspace();

}
