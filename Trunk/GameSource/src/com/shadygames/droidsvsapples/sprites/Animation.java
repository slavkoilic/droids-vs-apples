package com.shadygames.droidsvsapples.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Animation {
	private int refreshRate = 100;
	private int sWidth, sHeight, currentRow, currentColumn, numColumns, numRows;
	private long lastUpdate;
	public Animation(Texture t, int sourceWidth, int sourceHeight,long gameTime){
		sWidth = sourceWidth;
		sHeight = sourceHeight;
		currentColumn = 0;
		currentRow = 0;
		numColumns = t.getWidth()/sourceWidth;
		numRows = t.getHeight()/sourceHeight;
		lastUpdate = gameTime;
	}
	
	public Animation(Texture t, int sourceWidth, int sourceHeight,long gameTime, int theRefreshRate)
	{
		this(t,sourceWidth,sourceHeight,gameTime);
		if ( theRefreshRate != -1 )
			refreshRate = theRefreshRate;
	}
	
	public void update(long time)
	{
		if ( time - lastUpdate >= refreshRate )
		{
			lastUpdate = time;
			currentColumn++;
			if ( currentColumn >= numColumns )
			{
				currentColumn = 0;
				currentRow++;
				if ( currentRow >= numRows )
					currentRow = 0;
			}
		}
	}
	
	public Rectangle getSource()
	{
		return new Rectangle(currentColumn*sWidth,currentRow*sHeight,sWidth,sHeight);
	}
}
