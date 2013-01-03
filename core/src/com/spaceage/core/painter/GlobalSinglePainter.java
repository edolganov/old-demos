package com.spaceage.core.painter;

import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Window;

public class GlobalSinglePainter {
	
	Image img;
	
	public GlobalSinglePainter(Image img) {
		super();
		this.img = img;
	}
	
	public void drawImage(int x, int y, Window w, GraphicsManager manager, Object platformGraphics) {
		
		int windowX = x - w.x;
		if(Math.abs(windowX) >= w.width){
			return;
		}
		
		int windowY = y - w.y;
		if(Math.abs(windowY) >= w.height){
			return;
		}
		
		manager.draw(img, windowX, windowY, platformGraphics);
	}
	
	public boolean isVisible(int x, int y, Window w){
		int windowX = x - w.x;
		int windowY = y - w.y;
		return Math.abs(windowX) < w.width && Math.abs(windowY) < w.height;
	}
	
	

}
