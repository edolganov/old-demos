package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.core.G;
import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;

public class Scene {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	private Window w;
	private ScenePoint windowStartPoint;
	private ArrayList<SceneListener> listeners = new ArrayList<SceneListener>();
	
	public Scene() {
		this.w = new Window(G.initialWindow);
		windowStartPoint = new ScenePoint(w.x, w.y, 0, 0);
	}
	
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	public void addListener(SceneListener listener){
		listeners.add(listener);
	}
	
	public void draw(GraphicsManager manager, Object platformGraphics) {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			Window layerWindow = w; //TODO special for every layer
			layer.draw(layerWindow, manager, platformGraphics);
		}
	}

	public void updateScene() {
		
		beforeUpdate();
		
		updateWindowPosition();
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			layer.updateState(w);
		}
		
		afterUpdate();
	}


	private void beforeUpdate() {
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).beforeSceneUpdate();
		}
	}
	
	private void afterUpdate() {
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).afterSceneUpdate();
		}
	}
	
	public ScenePoint getWindowStartPoint(){
		return windowStartPoint;
	}


	private void updateWindowPosition() {
		windowStartPoint.move();
		w.x = windowStartPoint.getX();
		w.y = windowStartPoint.getY();
	}
	
	public int getWIndowX(){
		return w.x;
	}
	
	public int getWindowY(){
		return w.y;
	}



	
	

}
