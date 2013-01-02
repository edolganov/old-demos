package com.spaceage.core.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpritesContainer {
	
	private ArrayList<Sprite> sprites;
	private HashMap<String, Sprite> spritesMap;
	
	public Sprite createSprite(String resoursePath, int x, int y){

		
		Sprite sprite = new Sprite(resoursePath, x, y);
		addSprite(sprite);
		return sprite;
		
	}
	
	public void addSprite(Sprite sprite){
		initSpriteContainers();
		sprites.add(sprite);
		spritesMap.put(sprite.getId(), sprite);
	}
	
	
	private void initSpriteContainers() {
		if(sprites == null){
			sprites = new ArrayList<Sprite>();
			spritesMap = new HashMap<String, Sprite>();
		}
	}
	
	public List<Sprite> getList(){
		return sprites;
	}

}
