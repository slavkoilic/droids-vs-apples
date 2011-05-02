package com.shadygames.droidsvsapples;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;
import com.shadygames.droidsvsapples.screenmanager.screens.ScreenLoading;

public class DroidsVsApples implements ApplicationListener {
	private ScreenManager screenMan = null;
	private SpriteBatch spriteBatch = null;
        @Override
        public void create() {
        	spriteBatch = new SpriteBatch();
        	screenMan = new ScreenManager(spriteBatch);
        	screenMan.addScreen(new ScreenLoading());
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
        	spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
        }

        @Override
        public void resume() {
        	screenMan.resume();
        }
}