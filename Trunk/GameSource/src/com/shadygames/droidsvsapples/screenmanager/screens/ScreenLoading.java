package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.math.Rectangle;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;

public class ScreenLoading extends Screen {
    
    public ScreenLoading(ScreenManager manager)
    {
    	super(manager);
    	super.setBackground(new Rectangle(0,0,480,320),"Images/LoadingScreen512x512.png");
    	ScreenManager.currentScreenManager.setBackGroundMusic("Audio/background.wav");
    }
    
    @Override
    public void update()
    {
    	super.update();
    	if ( gameTime > 1000 )
    	{
    		ScreenManager.currentScreenManager.closeAndAdd(new MenuScreen(manager));
    	}
    		
    }

}
