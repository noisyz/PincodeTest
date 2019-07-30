package com.noisyz.pincodetest.modules.lockscreen.presenter;

import android.text.TextUtils;

import com.noisyz.pincodetest.R;
import com.noisyz.pincodetest.data.IStorageManager;
import com.noisyz.pincodetest.modules.common.presenter.BasePresenterImpl;
import com.noisyz.pincodetest.modules.lockscreen.SetupLockscreenContract;
import com.noisyz.pincodetest.modules.lockscreen.presenter.state.abs.LockscreenState;
import com.noisyz.pincodetest.modules.lockscreen.presenter.state.impl.ConfirmNewCodeState;
import com.noisyz.pincodetest.modules.lockscreen.presenter.state.impl.InputCodeState;
import com.noisyz.pincodetest.modules.lockscreen.presenter.state.impl.InputNewCodeState;
import com.noisyz.pincodetest.modules.lockscreen.presenter.state.impl.InputOldCodeState;

import java.util.ArrayList;
import java.util.List;

public class SetupLockscreenPresenter extends BasePresenterImpl<SetupLockscreenContract.View> implements SetupLockscreenContract.Presenter, LockscreenState.Callback {

    private List<LockscreenState> states;

    protected int currentIndex;

    public SetupLockscreenPresenter(IStorageManager storageManager) {
        super(storageManager);
        states = new ArrayList<>();

        if (TextUtils.isEmpty(storageManager.getPincode())) {
            states.add(new InputCodeState(this));
        } else {
            states.add(new InputOldCodeState(this));
            states.add(new InputNewCodeState(this));
        }

        states.add(new ConfirmNewCodeState(this));
    }

    @Override
    public void attachView(SetupLockscreenContract.View view) {
        super.attachView(view);

        moveTo(states.get(currentIndex));
    }


    @Override
    public void moveToNext(LockscreenState from) {
        if (canWeMoveFrom(from)) {
            currentIndex++;
            if (currentIndex < states.size()) {
                LockscreenState state = states.get(currentIndex);
                moveTo(state);
            } else {
                getStorageManager().savePincode(from.getInput());
                getView().finish();
            }
        }
    }

    protected void moveTo(LockscreenState state) {
        currentIndex = states.indexOf(state);
        state.init();
        getView().updateProgress(0);
        getView().updateTitle(state.getStateTitle());
        getView().updateActionText(state.getStateActionText());
    }

    protected boolean canWeMoveFrom(LockscreenState from) {
        switch (from.getStateCode()) {
            case InputOldCodeState.CODE:
                boolean result = TextUtils.equals(from.getInput(), getStorageManager().getPincode());
                if (!result) {
                    getView().showMessage(R.string.pin_error);
                }
                return result;
            case ConfirmNewCodeState.CODE:
                result = TextUtils.equals(from.getInput(), states.get(currentIndex - 1).getInput());
                if (!result) {
                    getView().showMessage(R.string.confirm_error);
                }
                return result;
        }
        return true;
    }

    @Override
    public void updateProgress(int progress) {
        getView().updateProgress(progress);
    }

    @Override
    public void input(String input) {
        states.get(currentIndex).input(input);
    }

    @Override
    public void backspace() {
        states.get(currentIndex).backspace();
    }


    @Override
    public void performAction() {
        switch (states.get(currentIndex).getStateCode()) {
            case InputCodeState.CODE:
                getView().finish();
                break;
            case ConfirmNewCodeState.CODE:
                moveTo(states.get(currentIndex - 1));
                break;
            case InputOldCodeState.CODE:
                getView().finish();
                break;
            case InputNewCodeState.CODE:
                getView().finish();
                break;
        }
    }
}