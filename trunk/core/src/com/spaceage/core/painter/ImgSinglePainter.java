package com.spaceage.core.painter;

import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;

public class ImgSinglePainter {
	
	Image img;
	int width;
	int height;
	
	public ImgSinglePainter(Image img) {
		super();
		this.img = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
		
	}
	
	public void drawImage(int x, int y, Window w, GraphicsManager manager, Object platformGraphics) {
		
		if( ! isVisible(x, y, w)){
			return;
		}
		
		int windowX = x - w.x;
		int windowY = y - w.y;
		manager.draw(img, windowX, windowY, platformGraphics);
	}
	
	public boolean isVisible(int x, int y, Window w){
		
		int windowX = x - w.x;
		if(windowX >=0 && windowX > w.width){
			return false;
		}
		if(windowX < 0 && windowX+width < 0){
			return false;
		}
		
		int windowY = y - w.y;
		if(windowY >=0 && windowY > w.height){
			return false;
		}
		if(windowY < 0 && windowY+height < 0){
			return false;
		}
		
		return true;
	}
	
	

}
