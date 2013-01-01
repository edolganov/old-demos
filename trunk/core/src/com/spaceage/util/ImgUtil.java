package com.spaceage.util;

public class ImgUtil {
	
	public static int clearAlpha(int rgba) {
		return ((0 & 0xFF) << 24) | ((rgba & 0xFF) << 16) | ((rgba & 0xFF) << 8) | ((rgba & 0xFF) << 0);
	}
	
	public static int getColor(int red, int green, int blue) {
		return ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF) << 0);
	}

    public static int getRed(int rgb) {
    	return (rgb >> 16) & 0xFF;
    }

    public static int getGreen(int rgb) {
    	return (rgb >> 8) & 0xFF;
    }

    public static int getBlue(int rgb) {
    	return (rgb >> 0) & 0xFF;
    }

}
