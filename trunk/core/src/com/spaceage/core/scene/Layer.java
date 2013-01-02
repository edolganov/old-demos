package com.spaceage.core.scene;

import java.util.List;

import com.spaceage.util.ColorUtil;

public abstract class Layer extends AbstractVisualObject {
	
	private SpritesContainer sprites = new SpritesContainer();
	
	
	public SpritesContainer getSpriteContainer() {
		return sprites;
	}


	@Override
	public int getRGBA(int x, int y){
		
		int outColor = getBackgroundRGBA(x, y);
		outColor = mixWithSprites(outColor, x, y);
		return outColor;
	}
	
	
	private int mixWithSprites(int outColor, int x, int y) {
		
		List<Sprite> list = sprites.getList();
		if(list == null){
			return outColor;
		}
		
		for(int i=0; i < list.size(); ++i){
			Sprite layerSprite = list.get(i);
			if(layerSprite.isVisible(x, y)){
				int spriteColor = layerSprite.getRGBA(x, y);
				outColor = ColorUtil.mixColors(outColor, spriteColor);
			}
		}
		
		return outColor;
	}


	protected abstract int getBackgroundRGBA(int x, int y);
	
	
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
