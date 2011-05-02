package com.shadygames.droidsvsapples.screenmanager.screens.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.shadygames.droidsvsapples.screenmanager.ScreenManager;
import com.shadygames.droidsvsapples.screenmanager.screens.MenuInterface;
import com.shadygames.droidsvsapples.sprites.Sprite;

public class MenuButton extends Sprite {
	private Sprite downState;
	private Sprite upState;
	private boolean clicked = false;
	private String text;
	private long clickTime;
	private int index;
	private MenuInterface caller;
	
	private Rectangle textLoc;
	
	public MenuButton(Rectangle source, Rectangle dest, String upLoc, String downLoc, String myText, long gameTime, int menuIndex, MenuInterface caller)
	{
		super((int)dest.x,(int)dest.y,(int)source.width,(int)source.height,(int)dest.width,(int)dest.height,new Texture(Gdx.files.internal(upLoc)),gameTime);
		downState = new Sprite((int)dest.x,(int)dest.y,(int)source.width,(int)source.height,(int)dest.width,(int)dest.height,new Texture(Gdx.files.internal(downLoc)),gameTime);
		upState = new Sprite((int)dest.x,(int)dest.y,(int)source.width,(int)source.height,(int)dest.width,(int)dest.height,new Texture(Gdx.files.internal(upLoc)),gameTime);
		text = myText;
		index = menuIndex;
		this.caller = caller;
		
		TextBounds b = ScreenManager.defaultFont.getBounds(text);
		textLoc = new Rectangle(x + (dWidth/2 - b.width/2),y+dHeight-b.height/4,0,0);
	}
	
	@Override
	public void onClick()
	{
		super.onClick();
		clicked = true;
		texture = downState.getTexture();
		animation = downState.getAnimation();
		clickTime = System.currentTimeMillis();
	}
	
	@Override
	public void render(SpriteBatch s)
	{
		super.render(s);
		ScreenManager.defaultFont.setColor(0.0f,1.0f,1.0f,0.7f);
		ScreenManager.defaultFont.draw(s, text, textLoc.x+2, textLoc.y+2);
		ScreenManager.defaultFont.setColor(1.0f,0.0f,0.0f,1.0f);
		ScreenManager.defaultFont.draw(s,text,textLoc.x,textLoc.y);
	}
	
	public void doClick(){
		clicked = false;
		texture = upState.getTexture();
		animation = upState.getAnimation();
		caller.onMenuSelect(index);
	}
	
	@Override
	public void update(long gameTime)
	{
		super.update(gameTime);
		if ( clicked )
			if ( System.currentTimeMillis() > clickTime + 100 )
			{
				doClick();
			}
	}
}
