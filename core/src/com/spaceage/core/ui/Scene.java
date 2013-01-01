package com.spaceage.core.ui;

import java.util.ArrayList;

public class Scene {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	
	public int getRGB(int x, int y){
		
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			
		}
		
		return 0xff332244;
	}
	
	
	

}
