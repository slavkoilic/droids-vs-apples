package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.math.Rectangle;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;
import com.shadygames.droidsvsapples.screenmanager.screens.components.MenuButton;

public class MenuScreen extends Screen implements MenuInterface {

	public MenuScreen()
	{
		setBackground(new Rectangle(0,0,ScreenManager.deviceWidth,ScreenManager.deviceHeight),"Images/paper_background.png");
		
		int desiredWidth = 350;
		
		sprites.add(new MenuButton(new Rectangle(0,0,291,62),new Rectangle(ScreenManager.deviceWidth/2-desiredWidth/2,180,desiredWidth,62),"Images/ButtonUp.png","Images/ButtonDown.png","Play Game",gameTime,0,this));
		sprites.add(new MenuButton(new Rectangle(0,0,291,62),new Rectangle(ScreenManager.deviceWidth/2-desiredWidth/2,120,desiredWidth,62),"Images/ButtonUp.png","Images/ButtonDown.png","Achievements",gameTime,1,this));
		sprites.add(new MenuButton(new Rectangle(0,0,291,62),new Rectangle(ScreenManager.deviceWidth/2-desiredWidth/2,60,desiredWidth,62),"Images/ButtonUp.png","Images/ButtonDown.png","Options",gameTime,2,this));
		sprites.add(new MenuButton(new Rectangle(0,0,291,62),new Rectangle(ScreenManager.deviceWidth/2-desiredWidth/2,0,desiredWidth,62),"Images/ButtonUp.png","Images/ButtonDown.png","Exit Game",gameTime,3,this));
	}
	
	@Override
	public void onMenuSelect(int index) {
		// TODO Auto-generated method stub
		System.err.println(index);
	}
	
	@Override
	public void handleClick(int x, int y)
	{
		super.handleClick(x,y);
	}

}
