package com.spaceage.core.painter;

import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.shape.Window;

public class ImgTilesPainter {
	
	Image img;
	int width;
	int height;
	
	public ImgTilesPainter(Image img) {
		super();
		this.img = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
	}
	
	public void drawImages(int x, int y, Window w, GraphicsManager manager, Object platformGraphics) {
		
		int positiveX = getPositiveX(w.x - x);
		int endX = positiveX + w.width;
		int stepsX = positiveX / width;
		int startX = width * stepsX;
		
		int positiveY = getPositiveY(w.y - y);
		int endY = positiveY + w.height;
		int stepsY = positiveY / height;
		int startY;
		
		int windowX;
		int windowY;
		while(startX <= endX){
			
			windowX = startX - positiveX;
			
			startY = height * stepsY;
			while(startY <= endY){
				
				windowY = startY - positiveY;
				manager.draw(img, windowX, windowY, platformGraphics);
				
				startY = startY + height;
			}
			startX = startX + width;
		}
	}
	
	
	
	private int getPositiveX(int wX) {
		if(wX >= 0){
			return wX;
		}
		int steps = wX / width;
		int startX = width * steps;
		if(startX > wX){
			startX = startX - width;
		}
		return (startX - wX) * -1;
	}
	
	private int getPositiveY(int wY) {
		if(wY >= 0){
			return wY;
		}
		int steps = wY / height;
		int startY = height * steps;
		if(startY > wY){
			startY = startY - height;
		}
		return (startY - wY) * -1;
	}
	
	

}
