package com.spaceage.core.scene;

import com.spaceage.core.G;

public class ScenePoint {
	
	//position
	private float x;
	private float y;
	
	//velocity
	private float dX;
	private float dY;
	
	//acceleration
	private float ddX;
	private float ddY;
	
	
	public ScenePoint(float x, float y, float dX, float dY) {
		super();
		this.x = x;
		this.y = y;
		this.dX = dX;
		this.dY = dY;
	}
	
	public void setVelocity(float dX, float dY) {
		setVelocityX(dX);
		setVelocityY(dY);
	}
	
	public void setVelocityX(float dX) {
		this.dX = dX * G.slowdownConst;
	}
	
	public void setVelocityY(float dY) {
		this.dY = dY * G.slowdownConst;
	}
	
	public void appendVelocity(float dX, float dY) {
		this.dX += dX * G.slowdownConst;
		this.dY += dY * G.slowdownConst;
	}
	
	public void setAcceleration(float ddX, float ddY){
		this.ddX = ddX * G.slowdownConst;
		this.ddY = ddY * G.slowdownConst;
	}
	
	public void appendAcceleration(float ddX, float ddY){
		this.ddX += ddX * G.slowdownConst;
		this.ddY += ddY * G.slowdownConst;
	}
	
	public void slowdownAccelerationX() {
		if(ddX > G.slowdownAccelerationX){
			ddX -= G.slowdownAccelerationX;
		} 
		else if(ddX < -G.slowdownAccelerationX){
			ddX += G.slowdownAccelerationX; 
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
		
		if(ddX > G.maxAcceleraton){
			ddX = G.maxAcceleraton;
		}
		else if(ddX < -G.maxAcceleraton){
			ddX = -G.maxAcceleraton;
		}
		
		if(ddY > G.maxAcceleraton){
			ddY = G.maxAcceleraton;
		}
		else if(ddY < -G.maxAcceleraton){
			ddY = -G.maxAcceleraton;
		}
		
		if(dX > G.maxVelocity){
			dX = G.maxVelocity;
		}
		else if(dX < -G.maxVelocity){
			dX = -G.maxVelocity;
		}
		
		if(dY > G.maxVelocity){
			dY = G.maxVelocity;
		}
		else if(dY < -G.maxVelocity){
			dY = -G.maxVelocity;
		}
	}

	public int getX() {
		return (int)x;
	}

	public int getY() {
		return (int)y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelocityX() {
		return dX;
	}

	public float getVelocityY() {
		return dY;
	}
	
	public float getAccelerationX(){
		return ddX;
	}
	
	public float getAccelerationY(){
		return ddY;
	}
	
	

}
