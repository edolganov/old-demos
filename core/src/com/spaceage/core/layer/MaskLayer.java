package com.spaceage.core.layer;

import com.spaceage.app.G;
import com.spaceage.core.painter.ImgSinglePainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.shape.Window;
import com.spaceage.util.ColorUtil;

public class MaskLayer extends Layer {
	
	ImgSinglePainter painter; 
	
	
	public MaskLayer(String resourcePath) {
		
		Image mask = G.factory().createImage(resourcePath);
		int width = mask.getWidth();
		int height = mask.getHeight();
		Image image = G.factory().createEmptyImage(width, height);
		
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
		
		painter = new ImgSinglePainter(image);
		
	}
	
	
	@Override
	protected void drawBackgroud(Window w, GraphicsManager manager, Object platformGraphics) {
		painter.drawImage(0, 0, w, manager, platformGraphics);
	}
	
	

}
