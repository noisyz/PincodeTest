package com.noisyz.pincodetest.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedManager {

    private static final String PREFS = "PincodeTest_SP", PREF_PINCODE = "SP_Pincode";

    private SharedPreferences sharedPreferences;

    public SharedManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void savePincode(String pinoode) {
        sharedPreferences.edit().putString(PREF_PINCODE, pinoode)
                .apply();
    }

    public String getPincode() {
        return sharedPreferences.getString(PREF_PINCODE, "");
    }
}
