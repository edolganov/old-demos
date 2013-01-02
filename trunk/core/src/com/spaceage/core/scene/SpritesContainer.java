package com.spaceage.core.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpritesContainer {
	
	private ArrayList<LayerSprite> sprites;
	private HashMap<String, LayerSprite> spritesMap;
	
	public LayerSprite createSprite(String resoursePath, int x, int y){

		
		LayerSprite sprite = new LayerSprite(resoursePath, x, y);
		addSprite(sprite);
		return sprite;
		
	}
	
	public void addSprite(LayerSprite sprite){
		initSpriteContainers();
		sprites.add(sprite);
		spritesMap.put(sprite.getId(), sprite);
	}
	
	
	private void initSpriteContainers() {
		if(sprites == null){
			sprites = new ArrayList<LayerSprite>();
			spritesMap = new HashMap<String, LayerSprite>();
		}
	}
	
	public List<LayerSprite> getList(){
		return sprites;
	}

}
