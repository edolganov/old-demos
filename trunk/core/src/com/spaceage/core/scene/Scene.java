package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.core.platform.GraphicsManager;

public class Scene extends AbstractVisualObject {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public Scene() {
		width = Integer.MAX_VALUE;
		height = Integer.MAX_VALUE;
	}
	
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	@Override
	public void draw(int x, int y, GraphicsManager manager, Object platformGraphics) {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			layer.draw(x, y, manager, platformGraphics);
		}
	}

	public void updateScene() {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			layer.updateState();
		}
	}



	
	

}
