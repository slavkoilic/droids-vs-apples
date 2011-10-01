package com.shadygames.droidsvsapples;

import com.badlogic.gdx.backends.jogl.JoglApplication;
import com.shadygames.droidsvsapples.EntryPoint.DroidsVsApples;

/**
 * Desktop version of the game.
 * @author Travis
 *
 */
public class DroidsVsApplesDesktop {
        public static void main (String[] argv) {
                new JoglApplication(new DroidsVsApples(), "Droids Vs Apples", 480, 320, false);               
        }
}