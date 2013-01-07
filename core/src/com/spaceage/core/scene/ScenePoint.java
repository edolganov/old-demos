package com.spaceage.core.scene;

import com.spaceage.core.G;

public class ScenePoint {
	
	//position
	private float x;
	private float y;
	
	//velocity
	private float dX;
	private float dY;
	private float maxVelocityX = G.maxVelocity;
	private float maxVelocityY = G.maxVelocity;
	
	//acceleration
	private float ddX;
	private float ddY;
	private float maxAccelerationX = G.maxAcceleration;
	private float maxAccelerationY = G.maxAcceleration;
	
	
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
		appendVelocityX(dX);
		appendVelocityY(dY);
	}
	
	public void appendVelocityX(float dX) {
		this.dX += dX * G.slowdownConst;
	}
	
	public void appendVelocityY(float dY) {
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
		
		dX += ddX;
		dY += ddY;
		
		limitVelocityAndAcceleration();
		
		x += dX;
		y += dY;
	}
	
	
	private void limitVelocityAndAcceleration() {
		
		if(ddX > maxAccelerationX){
			ddX = maxAccelerationX;
		}
		else if(ddX < -maxAccelerationX){
			ddX = -maxAccelerationX;
		}
		
		if(ddY > maxAccelerationY){
			ddY = maxAccelerationY;
		}
		else if(ddY < -maxAccelerationY){
			ddY = -maxAccelerationY;
		}
		
		if(dX > maxVelocityX){
			dX = maxVelocityX;
		}
		else if(dX < -maxVelocityX){
			dX = -maxVelocityX;
		}
		
		if(dY > maxVelocityY){
			dY = maxVelocityY;
		}
		else if(dY < -maxVelocityY){
			dY = -maxVelocityY;
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

	public void setMaxVelocityX(float maxVelocityX) {
		this.maxVelocityX = maxVelocityX;
	}
	
	public void setMaxVelocityY(float maxVelocityY) {
		this.maxVelocityY = maxVelocityY;
	}

	public void setMaxAccelerationX(float maxAccelerationX) {
		this.maxAccelerationX = maxAccelerationX;
	}
	
	public void setMaxAccelerationY(float maxAccelerationY) {
		this.maxAccelerationY = maxAccelerationY;
	}
	
	
	
	

}
