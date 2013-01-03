package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.app.Global;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.util.Util;

public class Sprite implements VisualObject {
	
	private String id;
	private ArrayList<Image> images;
	
	//cur position
	private double x;
	private double y;
	
	//speed vector
	private double speedX;
	private double speedY;
	
	private Sprite(int x, int y){
		id = Util.randomUUID();
		this.x = x;
		this.y = y;
		images = new ArrayList<Image>();
	}
	
	public Sprite(String resourcePath, int x, int y){
		this(x, y);
		
		//single img
		Image img = Global.factory.createImage(resourcePath);
		images.add(img);
		
	}
	
	public boolean isVisible(Window window){
		
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
	public void draw(Window window, GraphicsManager manager, Object platformGraphics) {
		
		if(images == null){
			return;
		}
	
		int spriteX = getSpriteX(globalX);
		int spriteY = getSpriteY(globalY);
	
		//single img
		if(images.size() == 1){
			images.get(0).draw(spriteX, spriteY, manager, platformGraphics);
			return;
		}
	
		//animated sprite
		//TODO
	}



	private int getSpriteX(int globalX) {
		return getX() - globalX;
	}
	
	private int getSpriteY(int globalY) {
		return getY() - globalY;
	}

	public void setSpeed(int speedX, int speedY) {
		this.speedX = speedX * Global.slowdownConst;
		this.speedY = speedY * Global.slowdownConst;
	}

	public int getX() {
		return (int)x;
	}

	public int getY() {
		return (int)y;
	}
	
	public double getRealX() {
		return x;
	}

	public double getRealY() {
		return y;
	}
	
	void move() {
		if(speedX != 0){
			x = x + speedX;
		}
		if(speedY != 0){
			y = y + speedY;
		}
	}

	public double getSpeedX() {
		return speedX;
	}

	public double getSpeedY() {
		return speedY;
	}


	
	
	

}
