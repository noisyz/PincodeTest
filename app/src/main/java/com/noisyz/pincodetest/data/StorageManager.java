package com.noisyz.pincodetest.data;

public class StorageManager implements IStorageManager {

    private SharedManager sharedManager;

    public StorageManager(SharedManager sharedManager) {
        this.sharedManager = sharedManager;
    }

    @Override
    public void savePincode(String pincode) {
        sharedManager.savePincode(pincode);
    }

    @Override
    public String getPincode() {
        return sharedManager.getPincode();
    }
}
