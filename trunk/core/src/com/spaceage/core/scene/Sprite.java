package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.app.Global;
import com.spaceage.core.painter.GlobalSinglePainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.util.Util;

public class Sprite implements VisualObject {
	
	private String id = Util.randomUUID();;
	private ArrayList<GlobalSinglePainter> painters = new ArrayList<GlobalSinglePainter>();
	
	//cur position
	private double x;
	private double y;
	
	//speed vector
	private double speedX;
	private double speedY;
	
	
	public Sprite(String resourcePath, int x, int y){
		this.x = x;
		this.y = y;
		//single img
		Image img = Global.factory.createImage(resourcePath);
		painters.add(new GlobalSinglePainter(img));
		
	}
	
	public boolean isVisible(Window w){
		
		if(Util.isEmpty(painters)){
			return false;
		}
		
		GlobalSinglePainter painter = painters.get(0);
		return painter.isVisible(getX(), getY(), w);
		
	}
	
	public String getId(){
		return id;
	}
	
	@Override
	public void draw(Window w, GraphicsManager manager, Object platformGraphics) {
		
		if(Util.isEmpty(painters)){
			return;
		}
		
		//TODO animated sprite
		GlobalSinglePainter painter = painters.get(0);
		painter.drawImage(getX(), getY(), w, manager, platformGraphics);

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
