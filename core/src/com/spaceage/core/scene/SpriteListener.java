package com.spaceage.core.scene;

public interface SpriteListener {
	
	public static enum Direciton {
		LEFT, RIGHT, UP, DOWN
	}
	
	void onTileCollision(Direciton direciton);
	
	void onNoTileCollision();

}
