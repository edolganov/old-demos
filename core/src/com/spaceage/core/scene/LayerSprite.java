package com.spaceage.core.scene;

public class LayerSprite implements VisualObject {
	
	private Sprite sprite;
	private int x;
	private int y;
	
	public LayerSprite(Sprite sprite, int x, int y) {
		super();
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}
	
	public boolean isVisible(int globalX, int globalY){
		
		int width = getWidth();
		int height = getHeight();
		int spriteX = getSpriteX(globalX);
		int spriteY = getSpriteY(globalY);
		
		return spriteX >= 0 && spriteX < width && spriteY >= 0 && spriteY < height;
		
	}
	
	public String getId(){
		return sprite.getId();
	}

	@Override
	public int getWidth() {
		return sprite.getWidth();
	}

	@Override
	public int getHeight() {
		return sprite.getHeight();
	}

	@Override
	public int getRGBA(int globalX, int globalY) {
		int spriteX = getSpriteX(globalX);
		int spriteY = getSpriteY(globalY);
		return sprite.getRGBA(spriteX, spriteY);
	}

	private int getSpriteY(int globalY) {
		return globalY - y;
	}

	private int getSpriteX(int globalX) {
		return globalX - x;
	}
	

}
