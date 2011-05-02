package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;

public class ScreenLoading extends Screen {
    
    public ScreenLoading()
    {
    	super();
    	addSprite(new Rectangle(0,0,480,320), new Rectangle(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()), "Images/LoadingScreen512x512.png", Integer.MAX_VALUE);
    	ScreenManager.currentScreenManager.setBackGroundMusic("Audio/background.wav");
    }
    
    @Override
    public void update()
    {
    	super.update();
    	if ( gameTime > 1000 )
    	{
    		ScreenManager.currentScreenManager.closeAndAdd(new MenuScreen());
    	}
    		
    }

}
