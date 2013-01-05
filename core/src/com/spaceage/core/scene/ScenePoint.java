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
	
	public void setVelocity(double dX, double dY) {
		this.dX = dX * G.slowdownConst();
		this.dY = dY * G.slowdownConst();
	}
	
	public void appendVelocity(double dX, double dY) {
		this.dX += dX * G.slowdownConst();
		this.dY += dY * G.slowdownConst();
	}
	
	public void setAcceleration(double ddX, double ddY){
		this.ddX = ddX * G.slowdownConst();
		this.ddY = ddY * G.slowdownConst();
	}
	
	public void appendAcceleration(double ddX, double ddY){
		this.ddX += ddX * G.slowdownConst();
		this.ddY += ddY * G.slowdownConst();
	}
	
	public void slowdownAccelerationX() {
		if(ddX > G.slowdownAccelerationX()){
			ddX -= G.slowdownAccelerationX();
		} 
		else if(ddX < -G.slowdownAccelerationX()){
			ddX += G.slowdownAccelerationX(); 
		}
		else {
			ddX = 0;
		}
		
	}
	
	
	public void move() {
		
		limitVelocityAndAcceleration();
		
		dX += ddX;
		dY += ddY;
		
		x += dX;
		y += dY;
	}
	
	
	private void limitVelocityAndAcceleration() {
		
		if(ddX > G.maxAcceleraton()){
			ddX = G.maxAcceleraton();
		}
		else if(ddX < -G.maxAcceleraton()){
			ddX = -G.maxAcceleraton();
		}
		
		if(ddY > G.maxAcceleraton()){
			ddY = G.maxAcceleraton();
		}
		else if(ddY < -G.maxAcceleraton()){
			ddY = -G.maxAcceleraton();
		}
		
		if(dX > G.maxVelocity()){
			dX = G.maxVelocity();
		}
		else if(dX < -G.maxVelocity()){
			dX = -G.maxVelocity();
		}
		
		if(dY > G.maxVelocity()){
			dY = G.maxVelocity();
		}
		else if(dY < -G.maxVelocity()){
			dY = -G.maxVelocity();
		}
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
	
	public double getAccelerationX(){
		return ddX;
	}
	
	public double getAccelerationY(){
		return ddY;
	}
	
	

}
