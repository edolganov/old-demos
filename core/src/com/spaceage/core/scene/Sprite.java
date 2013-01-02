package com.spaceage.core.scene;

import com.spaceage.util.Util;

public class Sprite implements VisualObject {
	
	private String id;
	private int width;
	private int height;
	
	public Sprite() {
		id = Util.randomUUID();
	}

	public String getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public int getRGBA(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
