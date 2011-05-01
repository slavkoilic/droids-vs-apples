package com.shadygames.droidsvsapples;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class DroidsVsApplesAndroid extends AndroidApplication {
    @Override
        public void onCreate (Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                initialize(new DroidsVsApples(), false);               
        }
}