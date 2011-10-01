package com.shadygames.droidsvsapples;

import android.content.res.Configuration;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.shadygames.droidsvsapples.EntryPoint.DroidsVsApples;

/**
 * Android version of the game.
 * @author Travis
 *
 */
public class DroidsVsApplesAndroid extends AndroidApplication {
    @Override
        public void onCreate (Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                initialize(new DroidsVsApples(), false);               
        }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
      // ignore orientation/keyboard change
      //super.onConfigurationChanged(newConfig);
    }
}