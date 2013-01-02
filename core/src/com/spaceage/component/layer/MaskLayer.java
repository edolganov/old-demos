package com.spaceage.component.layer;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.Platform;
import com.spaceage.core.scene.Layer;
import com.spaceage.util.ImgUtil;

public class MaskLayer extends Layer {
	
	int[][] img;
	
	
	public MaskLayer(String resourcePath) {
		Image maskImg = Platform.factory.createImage(resourcePath);
		createModelAndImg(maskImg);
		
	}

	private void createModelAndImg(Image mask) {
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
		if(x < 0 || x >= width || y < 0 || y >= height){
			return 0;
		}
		return img[x][y];
	}
	
	

}
