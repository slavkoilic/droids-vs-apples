package com.shadygames.droidsvsapples;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DroidsVsApples implements ApplicationListener {
        
        private Texture loadingScreen;
        private SpriteBatch spriteBatch;
        @Override
        public void create() {
                loadingScreen = new Texture(Gdx.files.internal("Images/LoadingScreen512x512.png"));
                spriteBatch = new SpriteBatch();
        }

        @Override
        public void dispose() { }

        @Override
        public void pause() { }

        @Override
        public void render() {
                Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
                spriteBatch.begin();
                spriteBatch.draw(loadingScreen, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),0,0,480,320,false,false);
                spriteBatch.end();
        }

        @Override
        public void resize(int width, int height) {
        	spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
        }

        @Override
        public void resume() { }
}