package com.spaceage.core.scene;

import com.spaceage.core.G;

public class ScenePoint {
	
	//position
	private float x;
	private float y;
	
	//velocity
	private float dX;
	private float dY;
	private float maxVelocity = G.maxVelocity;
	
	//acceleration
	private float ddX;
	private float ddY;
	private float maxAcceleration = G.maxAcceleration;
	
	
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
		
		if(ddX > maxAcceleration){
			ddX = maxAcceleration;
		}
		else if(ddX < -maxAcceleration){
			ddX = -maxAcceleration;
		}
		
		if(ddY > maxAcceleration){
			ddY = maxAcceleration;
		}
		else if(ddY < -maxAcceleration){
			ddY = -maxAcceleration;
		}
		
		if(dX > maxVelocity){
			dX = maxVelocity;
		}
		else if(dX < -maxVelocity){
			dX = -maxVelocity;
		}
		
		if(dY > maxVelocity){
			dY = maxVelocity;
		}
		else if(dY < -maxVelocity){
			dY = -maxVelocity;
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

	public void setMaxVelocity(float maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	public void setMaxAcceleration(float maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
	}
	
	
	
	

}
