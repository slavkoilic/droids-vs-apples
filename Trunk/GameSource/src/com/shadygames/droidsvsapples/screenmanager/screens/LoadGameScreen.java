/**
 * 
 */
package com.shadygames.droidsvsapples.screenmanager.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;

/**
 * @author Travis
 *
 */
public class LoadGameScreen extends Screen {

	/**
	 * @param creater
	 */
	public LoadGameScreen(ScreenManager creater) {
		super(creater);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void render(SpriteBatch s)
	{
		super.render(s);
		
		ScreenManager.defaultFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		ScreenManager.defaultFont.draw(s, "Loading Data...", 202, ScreenManager.deviceHeight - 50);
		
		ScreenManager.defaultFont.setColor(1.0f, 0.2f, 0.2f, 1.0f);
		ScreenManager.defaultFont.draw(s, "Loading Data...", 200, ScreenManager.deviceHeight - 52);
		
	}

}
