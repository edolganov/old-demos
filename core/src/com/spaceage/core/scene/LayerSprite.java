package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.Platform;
import com.spaceage.util.Util;

public class LayerSprite extends AbstractVisualObject {
	
	private String id;
	private ArrayList<Image> images;
	
	//cur position
	private int x;
	private int y;
	
	//speed vector
	private int speedX;
	private int speedY;
	
	public LayerSprite(String resourcePath, int x, int y){
		
		id = Util.randomUUID();
		
		Image img = Platform.factory.createImage(resourcePath);
		this.x = x;
		this.y = y;
		
		//single img
		images = new ArrayList<Image>();
		images.add(img);
		width = img.getWidth();
		height = img.getHeight();
		
	}
	
	public boolean isVisible(int globalX, int globalY){
		
		int width = getWidth();
		int height = getHeight();
		int spriteX = getSpriteX(globalX);
		int spriteY = getSpriteY(globalY);
		
		return spriteX >= 0 && spriteX < width && spriteY >= 0 && spriteY < height;
		
	}
	
	public String getId(){
		return id;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getRGBA(int globalX, int globalY) {
		
		if(images == null){
			return 0;
		}
		
		int spriteX = getSpriteX(globalX);
		int spriteY = getSpriteY(globalY);
		
		//single img
		if(images.size() == 1){
			return images.get(0).getRGBA(spriteX, spriteY);
		}
		
		//animated sprite
		//TODO
		return 0;
	}

	private int getSpriteY(int globalY) {
		return globalY - y;
	}

	private int getSpriteX(int globalX) {
		return globalX - x;
	}
	

}
