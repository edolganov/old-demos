package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.core.platform.SceneImage;

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
		
		int red = (int)(getRed(backRgb) * backFactor + getRed(layerRgba) * maskingFactor);
		int green = (int)(getGreen(backRgb) * backFactor + getGreen(layerRgba) * maskingFactor);
		int blue = (int)(getBlue(backRgb) * backFactor + getBlue(layerRgba) * maskingFactor);
		return getColor(red, green, blue);
	}


	public static final int getColor(int red, int green, int blue) {
		return ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF) << 0);
	}

    public static final int getRed(int rgb) {
    	return (rgb >> 16) & 0xFF;
    }

    public static final int getGreen(int rgb) {
    	return (rgb >> 8) & 0xFF;
    }

    public static final int getBlue(int rgb) {
    	return (rgb >> 0) & 0xFF;
    }
	
	

}
