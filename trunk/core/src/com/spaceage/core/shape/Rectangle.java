package com.spaceage.core.shape;

public class Rectangle {
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Rectangle(Rectangle w){
		this(w.x, w.y, w.width, w.height);
	}
	
	public Rectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
