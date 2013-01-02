package com.spaceage.core.scene;

public class LayerSprite {
	
	Sprite sprite;
	int x;
	int y;
	
	public LayerSprite(Sprite sprite, int x, int y) {
		super();
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}
	
	public boolean isVisible(int targetX, int targetY){
		
		int width = sprite.getWidth();
		int height = sprite.getHeight();
		
		return targetX >= x && targetX < (x+width) && targetY >= y && targetY < (y+height);
		
	}
	
//	public int getRGBA(int x, int y) {
//		
//	}
	
	

}
