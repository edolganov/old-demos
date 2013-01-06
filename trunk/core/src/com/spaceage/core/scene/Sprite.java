package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.app.G;
import com.spaceage.core.basic.Window;
import com.spaceage.core.painter.ImgSinglePainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.util.ColorUtil;
import com.spaceage.util.Util;

public class Sprite implements VisualObject {
	
	private String id = Util.randomUUID();;
	private ArrayList<ImgSinglePainter> painters = new ArrayList<ImgSinglePainter>();
	private ScenePoint startPoint;
	
	
	public Sprite(String resourcePath, int x, int y){
		startPoint = new ScenePoint(x, y, 0, 0);
		//single img
		Image img = G.factory().createImage(resourcePath);
		painters.add(new ImgSinglePainter(img));
		
	}
	
	public boolean isVisible(Window w){
		
		if(Util.isEmpty(painters)){
			return false;
		}
		
		ImgSinglePainter painter = painters.get(0);
		int x = startPoint.getX();
		int y = startPoint.getY();
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
		ImgSinglePainter painter = painters.get(0);
		int x = startPoint.getX();
		int y = startPoint.getY();
		painter.drawImage(x, y, w, manager, platformGraphics);
		
		
		
		if(G.showVelocityVector()){
			int width = painter.getWidth();
			int height = painter.getHeight();
			int vX1 = x + width/2;
			int vY1 = y + height/2;
			int vX2 = (vX1 + (int)startPoint.getVelocityX())*2;
			int vY2 = (vY1 + (int)startPoint.getVelocityY())*2;
			manager.drawLine(vX1, vY1, vX2, vY2, ColorUtil.RED, platformGraphics);
			manager.fillOval(vX2, vY2, 5, 5, ColorUtil.RED, platformGraphics);
		}

	}
	
	public ScenePoint getStartPoint(){
		return startPoint;
	}
	
	

}
