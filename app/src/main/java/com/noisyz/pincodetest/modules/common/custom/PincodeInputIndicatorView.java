package com.noisyz.pincodetest.modules.common.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.noisyz.pincodetest.R;

public class PincodeInputIndicatorView extends FrameLayout {

    private final int[] inputIds = new int[]{R.id.input_1, R.id.input_2, R.id.input_3, R.id.input_4};
    private final ImageView[] inputs = new ImageView[4];

    private int progress;

    public PincodeInputIndicatorView(Context context) {
        super(context);
        init();
    }

    public PincodeInputIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PincodeInputIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.pincode_input_indicator, this);

        for (int index = 0; index < inputs.length; index++) {
            inputs[index] = findViewById(inputIds[index]);
        }
    }

    public void setProgress(int progress) {
        this.progress = progress;
        updateUI();
    }

    private void updateUI() {
        for (int index = 0; index < inputs.length; index++) {
            inputs[index].setImageResource(index < progress ? R.drawable.pincode_input_indicator : R.drawable.pincode_input_indicator_empty);
        }
    }
}
