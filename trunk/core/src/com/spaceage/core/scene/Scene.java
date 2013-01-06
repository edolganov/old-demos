package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.app.G;
import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;

public class Scene {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	private Window w;
	private ScenePoint windowStartPoint;
	
	public Scene() {
		this.w = new Window(G.initialWindow);
		windowStartPoint = new ScenePoint(w.x, w.y, 0, 0);
	}
	
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	public void draw(GraphicsManager manager, Object platformGraphics) {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			Window layerWindow = w; //TODO special for every layer
			layer.draw(layerWindow, manager, platformGraphics);
		}
	}

	public void updateScene() {
		updateWindowPosition();
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			layer.updateState(w);
		}
	}
	
	private void updateWindowPosition() {
		windowStartPoint.move();
		w.x = windowStartPoint.getX();
		w.y = windowStartPoint.getY();
	}


	public void setWindowVelocity(float dX, float dY){
		windowStartPoint.setVelocity(dX, dY);
	}
	
	public int getWIndowX(){
		return w.x;
	}
	
	public int getWindowY(){
		return w.y;
	}



	
	

}
