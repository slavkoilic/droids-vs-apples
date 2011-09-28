package com.shadygames.droidsvsapples.EntryPoint;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;
import com.shadygames.droidsvsapples.screenmanager.screens.ScreenLoading;

/**
 * The entry point for the game.  All clients will create an instance of this class in order to play the game.
 * @author Travis
 *
 */
public class DroidsVsApples implements ApplicationListener {
	private ScreenManager screenMan = null;
	private SpriteBatch spriteBatch = null;
	
        @Override
        
        public void create() {
        	spriteBatch = new SpriteBatch();
        	spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, ScreenManager.deviceWidth, ScreenManager.deviceHeight);
        	screenMan = new ScreenManager(spriteBatch);
        	screenMan.addScreen(new ScreenLoading(screenMan));
        }

        @Override
        public void dispose() {
        	
        }

        @Override
        public void pause() {
        	screenMan.pause();
        }

        @Override
        public void render() {
        	screenMan.update();
        	screenMan.render();
        }

        @Override
        public void resize(int width, int height) {
        	
        }

        @Override
        public void resume() {
        	screenMan.resume();
        }
}