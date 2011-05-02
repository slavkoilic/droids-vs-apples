package com.shadygames.droidsvsapples.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Sprite {
	protected int x,y,sWidth,sHeight,dWidth,dHeight;
	protected Animation animation = null;
	protected Texture texture;
	
	public Sprite(int x, int y, int sourceWidth, int sourceHeight, int destWidth, int destHeight, Texture t, long gameTime){
		this(x,y,sourceWidth,sourceHeight,destWidth,destHeight,t,gameTime,-1);
	}
	
	public Sprite(int x, int y, int sourceWidth, int sourceHeight, int destWidth, int destHeight, Texture t, long gameTime, int animationRefresh){
		animation = new Animation(t, sourceWidth, sourceHeight, gameTime,animationRefresh);
		this.x = x;
		this.y = y;
		sWidth = sourceWidth;
		sHeight = sourceHeight;
		dWidth = destWidth;
		dHeight = destHeight;
		texture = t;
	}
	
	public boolean isClicked(int x, int y)
	{
		if ( x >= this.x && y >= this.y && x <= this.x + this.dWidth && y <= this.y + this.dHeight )
			return true;
		return false;
	}
	
	public void onClick()
	{
		
	}
	
	public Animation getAnimation()
	{
		return animation;
	}
	
	public Texture getTexture()
	{
		return texture;
	}
	
	public void render(SpriteBatch s)
	{
		Rectangle source = animation.getSource();
		s.draw(texture, x, y, dWidth, dHeight, (int)source.x, (int)source.y, (int)source.width, (int)source.height,false,false);
	}
	
	public void update(long gameTime)
	{
		animation.update(gameTime);
	}
}
