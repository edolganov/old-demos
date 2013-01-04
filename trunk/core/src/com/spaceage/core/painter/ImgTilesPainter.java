package com.spaceage.core.painter;

import java.util.ArrayList;

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
		
		ArrayList<Integer> xList = new ArrayList<Integer>();
		int positiveX = getPositiveX(w.x - x);
		int endX = positiveX + w.width;
		int stepsX = positiveX / width;
		int startX = width * stepsX;
		while(startX <= endX){
			xList.add(startX - positiveX);
			startX = startX + width;
		}
		
		
		ArrayList<Integer> yList = new ArrayList<Integer>();
		int positiveY = getPositiveY(w.y - y);
		int endY = positiveY + w.height;
		int stepsY = positiveY / height;
		int startY = height * stepsY;
		while(startY <= endY){
			yList.add(startY - positiveY);
			startY = startY + height;
		}
		
		for(int i=0; i< xList.size(); i++){
			for (int j = 0; j < yList.size(); j++) {
				int windowX = xList.get(i);
				int windowY = yList.get(j);
				manager.draw(img, windowX, windowY, platformGraphics);
			}
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
