package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.core.platform.GraphicsManager;

public class Scene {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	private Window window;
	
	public Scene(Window window) {
		this.window = new Window(window);
	}
	
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	public void draw(GraphicsManager manager, Object platformGraphics) {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			Window layerWindow = window; //TODO special for every layer
			layer.draw(layerWindow, manager, platformGraphics);
		}
	}

	public void updateScene() {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			layer.updateState();
		}
	}
	
	public void moveWindow(int dx, int dy){
		window.x = window.x + dx;
		window.y = window.y + dy;
	}



	
	

}
