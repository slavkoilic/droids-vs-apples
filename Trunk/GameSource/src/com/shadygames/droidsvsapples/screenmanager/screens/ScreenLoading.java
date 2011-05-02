package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shadygames.droidsvsapples.sprites.Sprite;

public class ScreenLoading extends Screen {
    
    public ScreenLoading()
    {
    	super();
    	sprites.add(new Sprite(0,0,480,320,Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),new Texture(Gdx.files.internal("Images/LoadingScreen512x512.png")), gameTime, Integer.MAX_VALUE));
    }
    
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		// TODO Auto-generated method stub
		super.render(spriteBatch);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		
	}

}
