package com.spaceage.util;

public class ColorUtil {
	
	public static final int WHITE_COLOR = 0xFFFFFFFF;
	public static final int EMPTY_COLOR = 0;
	
	public static int clearAlpha(int rgba) {
		return ((0 & 0xFF) << 24) | ((rgba & 0xFF) << 16) | ((rgba & 0xFF) << 8) | ((rgba & 0xFF) << 0);
	}
	
	public static int getColor(int red, int green, int blue) {
		return getColor(red, green, blue, 255);
	}
	
	public static int getColor(int red, int green, int blue, int alpha) {
		return ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF) << 0);
	}
	
    public static int getAlpha(int rgb) {
    	return (rgb >> 24) & 0xFF;
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
    
	public static int mixColors(int backRgba, int frontRgba) {
		int frontAlpha = getAlpha(frontRgba);
		double maskingFactor = frontAlpha / 255.0;
		double backFactor = 1 - maskingFactor;
		
		int red = (int)(getRed(backRgba) * backFactor + getRed(frontRgba) * maskingFactor);
		int green = (int)(getGreen(backRgba) * backFactor + getGreen(frontRgba) * maskingFactor);
		int blue = (int)(getBlue(backRgba) * backFactor + getBlue(frontRgba) * maskingFactor);
		
		int finalAlpha = getAlpha(backRgba);
		if(finalAlpha == 0){
			finalAlpha = frontAlpha;
		}
		return getColor(red, green, blue, finalAlpha);
	}

}
