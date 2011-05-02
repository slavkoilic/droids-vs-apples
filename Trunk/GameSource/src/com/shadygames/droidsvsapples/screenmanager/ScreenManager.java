package com.shadygames.droidsvsapples.screenmanager;

import java.util.Stack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shadygames.droidsvsapples.screenmanager.screens.*;

public class ScreenManager {
	private Stack<Screen> screens = new Stack<Screen>();
	private SpriteBatch spriteBatch;
	private Music playingMusic;
	
	public static final int deviceWidth = 480;
	public static final int deviceHeight = 320;
	public static ScreenManager currentScreenManager = null;
	
	public static BitmapFont defaultFont = null;
	
	public ScreenManager(SpriteBatch sBatch){
		currentScreenManager = this;
		spriteBatch = sBatch;
		if ( defaultFont == null )
		{
			defaultFont = new BitmapFont(Gdx.files.internal("Font/chancery.fnt"),false);
			defaultFont.setColor(1.0f,.2f,.2f,1.0f);
			defaultFont.setScale(1.2f);
		}
	}
	
	public void addScreen(Screen s)
	{
		screens.push(s);
	}
	
	public void setBackGroundMusic(String loc)
	{
		playingMusic = Gdx.audio.newMusic(Gdx.files.internal(loc));
		playingMusic.setLooping(true);
		playingMusic.play();
	}
	
	public void closeAndAdd(Screen s)
	{
		closeScreen();
		addScreen(s);
	}
	
	public void closeScreen()
	{
		screens.pop().dispose();
	}
	
	public void render(){
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		screens.lastElement().render(spriteBatch);
		spriteBatch.end();
	}
	
	private void handleInput()
	{
		if ( Gdx.app.getInput().justTouched() )
			screens.lastElement().handleClick(Gdx.input.getX(), deviceHeight-Gdx.input.getY());
	}
	
	public void update(){
		handleInput();
		screens.lastElement().update();
	}
	
	public void pause(){
		screens.lastElement().pause();
	}
	
	public void resume(){
		screens.lastElement().resume();
	}
	
	public void dispose(){
		playingMusic.dispose();
		while ( screens.size() != 0 )
			screens.pop().dispose();
	}
}
