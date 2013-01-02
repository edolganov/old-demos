package com.spaceage.component.layer;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.Platform;
import com.spaceage.core.scene.Layer;
import com.spaceage.util.ImgUtil;

public class MaskLayer extends Layer {
	
	int[][] img;
	
	
	public MaskLayer(String resourcePath) {
		
		Image mask = Platform.factory.createImage(resourcePath);
		width = mask.getWidth();
		height = mask.getHeight();
		img = new int[width][height];
		
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				int imgColor;
				int maskColor = mask.getRGBA(x, y);
				if(ImgUtil.clearAlpha(maskColor) == 0){
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
