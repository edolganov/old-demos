package com.spaceage.component.layer;

import com.spaceage.app.Global;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.scene.Window;
import com.spaceage.util.ColorUtil;

public class MaskLayer extends Layer {
	
	Image image;
	
	
	public MaskLayer(String resourcePath) {
		
		Image mask = Global.factory.createImage(resourcePath);
		int width = mask.getWidth();
		int height = mask.getHeight();
		image = Global.factory.createEmptyImage(width, height);
		
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				int imgColor;
				int maskColor = mask.getRGBA(x, y);
				if(ColorUtil.clearAlpha(maskColor) == 0){
					imgColor = 0;
				} else {
					imgColor = maskColor;
				}
				image.setRGBA(x, y, imgColor);
			}
		}
		
	}
	
	
	@Override
	protected void drawBackgroud(Window window, GraphicsManager manager, Object platformGraphics) {
		manager.draw(image, x, y, platformGraphics);
	}
	
	

}
