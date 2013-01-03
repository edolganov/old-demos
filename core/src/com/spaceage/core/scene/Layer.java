package com.spaceage.core.scene;

import java.util.List;

import com.spaceage.core.platform.GraphicsManager;

public abstract class Layer extends AbstractVisualObject {
	
	private SpritesContainer sprites = new SpritesContainer();
	
	
	public SpritesContainer getSpriteContainer() {
		return sprites;
	}


//	@Override
//	public int getRGBA(int x, int y){
//		
//		int outColor = getBackgroundRGBA(x, y);
//		outColor = mixWithSprites(outColor, x, y);
//		return outColor;
//	}
	
	@Override
	public void draw(int x, int y, GraphicsManager manager, Object platformGraphics) {
		drawBackgroud(x, y, manager, platformGraphics);
		drawSprites(x, y, manager, platformGraphics);
	}

	protected abstract void drawBackgroud(int x, int y, GraphicsManager manager, Object platformGraphics);
	
	
	private void drawSprites(int x, int y, GraphicsManager manager, Object platformGraphics) {
		
		List<Sprite> list = sprites.getList();
		if(list == null){
			return;
		}
		
		for(int i=0; i < list.size(); ++i){
			Sprite sprite = list.get(i);
			if(sprite.isVisible(x, y)){
				sprite.draw(x, y, manager, platformGraphics);
			}
		}
	}
	
	
	public void updateState() {
		List<Sprite> list = sprites.getList();
		if(list == null){
			return;
		}
		
		//move all sprites
		for(int i=0; i < list.size(); ++i){
			Sprite sprite = list.get(i);
			sprite.move();
		}
	}

}
