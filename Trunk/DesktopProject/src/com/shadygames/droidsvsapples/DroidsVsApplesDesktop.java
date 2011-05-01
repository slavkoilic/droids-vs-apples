package com.shadygames.droidsvsapples;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DroidsVsApplesDesktop {
        public static void main (String[] argv) {
                new JoglApplication(new DroidsVsApples(), "Droids Vs Apples", 480, 320, false);               
        }
}