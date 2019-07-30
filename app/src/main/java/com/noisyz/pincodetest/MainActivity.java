package com.noisyz.pincodetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noisyz.pincodetest.modules.lockscreen.ui.LockScreenActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.setup_pin).setOnClickListener(this);
        findViewById(R.id.auth_pin).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setup_pin:
                LockScreenActivity.showSetupLockscreen(this);
                break;
            case R.id.auth_pin:
                LockScreenActivity.showLockscreen(this);
                break;
        }
    }
}
