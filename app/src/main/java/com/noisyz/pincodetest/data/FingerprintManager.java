package com.noisyz.pincodetest.data;

import android.content.Context;
import com.mtramin.rxfingerprint.RxFingerprint;
import com.mtramin.rxfingerprint.data.FingerprintAuthenticationResult;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class FingerprintManager {

    public static boolean isFingerprintAvailable(Context context){
        return RxFingerprint.isAvailable(context) && RxFingerprint.hasEnrolledFingerprints(context);
    }

    public static Disposable subscribeForFingerprintAuth(Context context, final Callback callback) {
            return RxFingerprint.authenticate(context)
                    .subscribe(new Consumer<FingerprintAuthenticationResult>() {
                        @Override
                        public void accept(FingerprintAuthenticationResult fingerprintAuthenticationResult) throws Exception {
                            switch (fingerprintAuthenticationResult.getResult()) {
                                case FAILED:
                                    callback.onErrorMessage(fingerprintAuthenticationResult.getMessage());
                                    break;
                                case AUTHENTICATED:
                                    callback.onFingerPrintAuth();
                                    break;
                                case HELP:
                                    callback.onErrorMessage(fingerprintAuthenticationResult.getMessage());
                                    break;
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            callback.onErrorMessage(throwable.getLocalizedMessage());
                        }
                    });
    }

    public interface Callback {

        void onFingerPrintAuth();

        void onErrorMessage(String message);

    }
}
