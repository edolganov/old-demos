package com.spaceage.core.scene;

import com.spaceage.app.G;

public class ScenePoint {
	
	//position
	private double x;
	private double y;
	
	//velocity
	private double dX;
	private double dY;
	
	//acceleration
	private double ddX;
	private double ddY;
	
	
	public ScenePoint(double x, double y, double dX, double dY) {
		super();
		this.x = x;
		this.y = y;
		this.dX = dX;
		this.dY = dY;
	}
	
	public void setVelocity(int dX, int dY) {
		this.dX = dX * G.slowdownConst();
		this.dY = dY * G.slowdownConst();
	}
	
	public void setAcceleration(int ddX, int ddY){
		this.ddX = ddX * G.slowdownConst();
		this.ddY = ddY * G.slowdownConst();
	}
	
	
	public void move() {
		x = x + dX;
		y = y + dY;
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

	public double getVelocityX() {
		return dX;
	}

	public double getVelocityY() {
		return dY;
	}
	
	

}
