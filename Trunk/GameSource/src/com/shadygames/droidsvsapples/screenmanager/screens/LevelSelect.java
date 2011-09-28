package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.math.Rectangle;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;

public class LevelSelect extends Screen implements MenuInterface {
	public LevelSelect(ScreenManager screenMan){
		//sprites.add(new MenuButton())
		super(screenMan);
		
		setBackground(new Rectangle(0,0,ScreenManager.deviceWidth,ScreenManager.deviceHeight),"Images/paper_background.png");
	}
	
	@Override
	public void update(){
		super.update();
	}

	@Override
	public void onMenuSelect(int index) {
		
		
	}
}
