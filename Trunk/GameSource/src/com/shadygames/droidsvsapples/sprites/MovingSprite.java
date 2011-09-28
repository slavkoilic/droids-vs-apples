/**
 * 
 */
package com.shadygames.droidsvsapples.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * @author Travis
 *
 */
public class MovingSprite extends Sprite {

	/**
	 * @param x
	 * @param y
	 * @param sourceWidth
	 * @param sourceHeight
	 * @param destWidth
	 * @param destHeight
	 * @param t
	 * @param gameTime
	 */
	public MovingSprite(int x, int y, int sourceWidth, int sourceHeight,
			int destWidth, int destHeight, Texture t, long gameTime) {
		super(x, y, sourceWidth, sourceHeight, destWidth, destHeight, t,
				gameTime);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param sourceWidth
	 * @param sourceHeight
	 * @param destWidth
	 * @param destHeight
	 * @param t
	 * @param gameTime
	 * @param animationRefresh
	 */
	public MovingSprite(int x, int y, int sourceWidth, int sourceHeight,
			int destWidth, int destHeight, Texture t, long gameTime,
			int animationRefresh) {
		super(x, y, sourceWidth, sourceHeight, destWidth, destHeight, t,
				gameTime, animationRefresh);
		// TODO Auto-generated constructor stub
	}

}
