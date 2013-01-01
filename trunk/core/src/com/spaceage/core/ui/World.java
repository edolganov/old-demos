package com.spaceage.core.ui;

import java.util.ArrayList;

public class World {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	
	public RGB getRGB(int x, int y){
		return new RGB(100, 100, 100);
	}
	
	
	

}
