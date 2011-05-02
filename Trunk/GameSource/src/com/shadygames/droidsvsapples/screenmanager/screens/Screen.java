package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.shadygames.droidsvsapples.sprites.Sprite;

public abstract class Screen {
	protected long gameTime = 0;
	protected long lastTimeUpdate = 0;
	
	protected boolean paused = false;
	
	protected Array<Sprite> sprites = new Array<Sprite>();
	
	
	
	public Screen(){
		lastTimeUpdate = System.currentTimeMillis();
	}
	
	public void update(){
		if ( !paused )
		{
			gameTime += System.currentTimeMillis() - lastTimeUpdate;
			for ( int i = 0; i < sprites.size; i++ )
				sprites.items[i].update(gameTime);
		}
	}
	
	public void render(SpriteBatch spriteBatch){
		if ( !paused )
		{
			for ( int i = 0; i < sprites.size; i++ )
				sprites.get(i).render(spriteBatch);
		}
	}
	
	public void dispose(){
		
	}
	
	public void pause(){
		paused = true;
	}
	
	public void resume(){
		paused = false;
	}
}
