package com.spaceage.core.scene;

import java.util.ArrayList;
import java.util.HashMap;

import com.spaceage.util.ColorUtil;
import com.spaceage.util.Util;

public abstract class Layer extends AbstractVisualObject {
	
	private ArrayList<LayerSprite> sprites;
	private HashMap<String, LayerSprite> spritesMap;

	
	public void addSprite(Sprite sprite, int x, int y){
		initSpriteContainers();
		
		LayerSprite layerSprite = new LayerSprite(sprite, x, y);
		sprites.add(layerSprite);
		spritesMap.put(layerSprite.getId(), layerSprite);
		
	}
	
	
	private void initSpriteContainers() {
		if(sprites == null){
			sprites = new ArrayList<LayerSprite>();
			spritesMap = new HashMap<String, LayerSprite>();
		}
	}


	@Override
	public int getRGBA(int x, int y){
		
		int outColor = getBackgroundRGBA(x, y);
		outColor = mixWithSprites(outColor, x, y);
		return outColor;
	}
	
	
	private int mixWithSprites(int outColor, int x, int y) {
		
		if(Util.isEmpty(sprites)){
			return outColor;
		}
		
		for(int i=0; i < sprites.size(); ++i){
			LayerSprite layerSprite = sprites.get(i);
			if(layerSprite.isVisible(x, y)){
				int spriteColor = layerSprite.getRGBA(x, y);
				outColor = ColorUtil.mixColors(outColor, spriteColor);
			}
		}
		
		return outColor;
	}


	protected abstract int getBackgroundRGBA(int x, int y);

}
