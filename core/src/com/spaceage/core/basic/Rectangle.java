package com.spaceage.core.basic;

public class Rectangle {
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Rectangle(Rectangle rec){
		this(rec.x, rec.y, rec.width, rec.height);
	}
	
	public Rectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
