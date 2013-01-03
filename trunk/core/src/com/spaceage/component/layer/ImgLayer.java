package com.spaceage.component.layer;

import java.util.ArrayList;

import com.spaceage.app.Global;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.scene.Window;

public class ImgLayer extends Layer {
	
	Image img;
	int width;
	int height;
	
	public ImgLayer(String resourcePath) {
		img = Global.factory.createImage(resourcePath);
		width = img.getWidth();
		height = img.getHeight();
	}
	
	@Override
	protected void drawBackgroud(Window w, GraphicsManager manager, Object platformGraphics) {
		
		ArrayList<Integer> xList = new ArrayList<Integer>();
		int positiveX = getPositiveX(w);
		int endX = positiveX + w.width;
		int stepsX = positiveX % width;
		int startX = width * stepsX;
		while(startX <= endX){
			xList.add(startX - positiveX);
			startX = startX + width;
		}
		
		
		ArrayList<Integer> yList = new ArrayList<Integer>();
		int positiveY = getPositiveY(w);
		int endY = positiveY + w.height;
		int stepsY = positiveY % height;
		int startY = height * stepsY;
		while(startY <= endY){
			yList.add(startY - positiveY);
			startY = startY + height;
		}
		
		for(int i=0; i< xList.size(); i++){
			for (int j = 0; j < yList.size(); j++) {
				int x = xList.get(i);
				int y = yList.get(j);
				manager.draw(img, x, y, platformGraphics);
			}
		}
	}

	private int getPositiveX(Window w) {
		if(w.x >= 0){
			return w.x;
		}
		int steps = w.x % width;
		int startX = width * steps;
		if(startX > w.x){
			startX = startX - width;
		}
		return (startX - w.x) * -1;
	}
	
	private int getPositiveY(Window w) {
		if(w.y >= 0){
			return w.y;
		}
		int steps = w.y % height;
		int startY = height * steps;
		if(startY > w.y){
			startY = startY - height;
		}
		return (startY - w.y) * -1;
	}

}
