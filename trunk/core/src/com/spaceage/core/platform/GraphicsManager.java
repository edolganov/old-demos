package com.spaceage.core.platform;

public interface GraphicsManager {
	
	void draw(Image image, int imageStartX, int imageStartY, Object platformGraphics);
	
	void drawLine(int x1, int y1, int x2, int y2, int rgba, Object platformGraphics);
	
	void fillOval(int x, int y, int width, int height, int rgba, Object platformGraphics);

}
