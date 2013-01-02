package com.spaceage.core.scene;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Layer extends VisualObject {
	
	private ArrayList<LayerSprite> sprites;
	private HashMap<String, LayerSprite> spritesMap;
	protected int width;
	protected int height;
	
	public void addSprite(Sprite sprite, int x, int y){
		initSpriteContainers();
		
		LayerSprite layerSprite = new LayerSprite(sprite, x, y);
		sprites.add(layerSprite);
		spritesMap.put(layerSprite.sprite.getId(), layerSprite);
		
	}
	
	
	private void initSpriteContainers() {
		if(sprites == null){
			sprites = new ArrayList<LayerSprite>();
			spritesMap = new HashMap<String, LayerSprite>();
		}
	}


	@Override
	public int getRGBA(int x, int y){
		return getBackgroundRGBA(x, y);
	}
	
	@Override
	public int getWidth() {
		return width;
	}


	@Override
	public int getHeight() {
		return height;
	}
	
	
	protected abstract int getBackgroundRGBA(int x, int y);

}
