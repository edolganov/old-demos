package com.spaceage.component.layer;

import com.spaceage.app.Global;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.util.ColorUtil;

public class MaskLayer extends Layer {
	
	int[][] img;
	
	
	public MaskLayer(String resourcePath) {
		
		Image mask = Global.factory.createImage(resourcePath);
		width = mask.getWidth();
		height = mask.getHeight();
		img = new int[width][height];
		
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				int imgColor;
				int maskColor = mask.getRGBA(x, y);
				if(ColorUtil.clearAlpha(maskColor) == 0){
					imgColor = 0;
				} else {
					imgColor = maskColor;
				}
				img[x][y] = imgColor;
			}
		}
		
	}

	@Override
	protected int getBackgroundRGBA(int x, int y) {
		if( ! inBounds(x, y)){
			return 0;
		}
		return img[x][y];
	}
	
	

}
