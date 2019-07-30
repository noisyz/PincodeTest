package com.noisyz.pincodetest.di;

import javax.inject.Scope;

public class Scopes {
    @Scope
    public @interface ApplicationScope {
    }

    @Scope
    public @interface FragmentScope {
    }
}