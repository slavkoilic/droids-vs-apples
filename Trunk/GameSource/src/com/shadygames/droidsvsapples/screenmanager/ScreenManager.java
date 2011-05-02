package com.shadygames.droidsvsapples.screenmanager;

import java.util.Stack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shadygames.droidsvsapples.screenmanager.screens.*;

public class ScreenManager {
	private Stack<Screen> screens = new Stack<Screen>();
	private SpriteBatch spriteBatch;
	public ScreenManager(SpriteBatch sBatch){
		spriteBatch = sBatch;
	}
	
	public void addScreen(Screen s)
	{
		screens.push(s);
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
	
	public void update(){
		screens.lastElement().update();
	}
	
	public void pause(){
		screens.lastElement().pause();
	}
	
	public void resume(){
		screens.lastElement().resume();
	}
}
