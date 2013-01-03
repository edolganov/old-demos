package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.app.Global;
import com.spaceage.core.painter.GlobalSinglePainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.util.Util;

public class Sprite implements VisualObject {
	
	private String id = Util.randomUUID();;
	private ArrayList<GlobalSinglePainter> painters = new ArrayList<GlobalSinglePainter>();
	private ScenePoint spritePoint;
	
	
	public Sprite(String resourcePath, int x, int y){
		spritePoint = new ScenePoint(x, y, 0, 0);
		//single img
		Image img = Global.factory.createImage(resourcePath);
		painters.add(new GlobalSinglePainter(img));
		
	}
	
	public boolean isVisible(Window w){
		
		if(Util.isEmpty(painters)){
			return false;
		}
		
		GlobalSinglePainter painter = painters.get(0);
		int x = spritePoint.getX();
		int y = spritePoint.getY();
		return painter.isVisible(x, y, w);
		
	}
	
	public String getId(){
		return id;
	}
	
	@Override
	public void draw(Window w, GraphicsManager manager, Object platformGraphics) {
		
		if(Util.isEmpty(painters)){
			return;
		}
		
		//TODO animated sprite
		GlobalSinglePainter painter = painters.get(0);
		int x = spritePoint.getX();
		int y = spritePoint.getY();
		painter.drawImage(x, y, w, manager, platformGraphics);

	}

	public void setVelocity(int dX, int dY) {
		spritePoint.setVelocity(dX, dY);
	}


	public void move() {
		spritePoint.move();
	}
	
	

}
