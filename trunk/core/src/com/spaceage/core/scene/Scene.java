package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.core.platform.SceneImage;
import com.spaceage.util.ImgUtil;

public class Scene implements SceneImage {
	
	private static final int BACKGROUNG_COLOR = 0xFFFFFF;
	
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	
	@Override
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
		double backFactor = 1 - maskingFactor;
		
		int red = (int)(ImgUtil.getRed(backRgb) * backFactor + ImgUtil.getRed(layerRgba) * maskingFactor);
		int green = (int)(ImgUtil.getGreen(backRgb) * backFactor + ImgUtil.getGreen(layerRgba) * maskingFactor);
		int blue = (int)(ImgUtil.getBlue(backRgb) * backFactor + ImgUtil.getBlue(layerRgba) * maskingFactor);
		return ImgUtil.getColor(red, green, blue);
	}
	
	

}
