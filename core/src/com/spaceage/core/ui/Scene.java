package com.spaceage.core.ui;

import java.util.ArrayList;

public class Scene {
	
	private static final int BACKGROUNG_COLOR = 0xFFFFFF;
	
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	
	public int getRGB(int x, int y){
		
		int rgb = BACKGROUNG_COLOR;
		
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			int rgba = getLayerRGBA(i, x, y, layer);
			rgb = mixColors(rgb, rgba);
		}
		
		return rgb;
	}


	private int getLayerRGBA(int index, int globalX, int globalY, Layer layer) {
		return layer.getRGBA(globalX, globalY);
	}
	

	private int mixColors(int backRgb, int layerRgba) {
		int alpha = (layerRgba >> 24) & 0xff;
		double maskingFactor = alpha / 255.0;
		int out = (int)(backRgb * (1 - maskingFactor) + layerRgba * maskingFactor);
		return out;
	}
	
	
	

}
