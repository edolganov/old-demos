package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.util.ColorUtil;

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
	public int getRGBA(int x, int y){
		
		int outColor = ColorUtil.WHITE_COLOR;
		
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			int layerColor = getLayerRGBA(i, x, y, layer);
			outColor = ColorUtil.mixColors(outColor, layerColor);
		}
		
		return outColor;
	}


	private int getLayerRGBA(int index, int globalX, int globalY, Layer layer) {
		return layer.getRGBA(globalX, globalY);
	}

	public void updateScene() {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			layer.updateState();
		}
	}
	
	

}
