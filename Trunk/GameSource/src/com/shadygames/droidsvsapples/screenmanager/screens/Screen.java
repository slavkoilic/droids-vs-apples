package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
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
	
	public void setBackground(Rectangle source, String texLoc)
	{
		addSprite(source,new Rectangle(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()),texLoc);
	}
	
	public void addSprite(Rectangle source, Rectangle dest, String texLoc, int animationRefresh)
	{
		sprites.add(new Sprite((int)dest.x,(int)dest.y,(int)source.width,(int)source.height,(int)dest.width,(int)dest.height,new Texture(Gdx.files.internal(texLoc)),animationRefresh));
	}
	
	public void addSprite(Rectangle source, Rectangle dest, String texLoc)
	{
		addSprite(source,dest,texLoc,-1);
	}
	
	public void update(){
		if ( !paused )
		{
			gameTime += System.currentTimeMillis() - lastTimeUpdate;
			for ( int i = 0; i < sprites.size; i++ )
				sprites.get(i).update(gameTime);
		}
		lastTimeUpdate = System.currentTimeMillis();
	}
	
	public void handleClick(int x, int y)
	{
		for ( int i = 0; i < sprites.size; i++ )
			if ( sprites.get(i).isClicked(x,y) )
				sprites.get(i).onClick();
	}
	
	public void handleLongClick(int x, int y)
	{
		
	}
	
	public void render(SpriteBatch spriteBatch){
		if ( !paused )
		{
			for ( int i = 0; i < sprites.size; i++ )
				sprites.get(i).render(spriteBatch);
		}
	}
	
	public void dispose(){
		sprites.clear();
	}
	
	public void pause(){
		paused = true;
	}
	
	public void resume(){
		paused = false;
	}
}
