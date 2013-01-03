package com.spaceage.core.scene;

public class Window {
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Window(Window w){
		this(w.x, w.y, w.width, w.height);
	}
	
	public Window(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
