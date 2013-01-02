package com.spaceage.component.layer;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.Platform;
import com.spaceage.core.scene.Layer;

public class ImgLayer extends Layer {
	
	Image img;
	int imgWith;
	int imgHeight;
	
	public ImgLayer(String resourcePath) {
		img = Platform.factory.createImage(resourcePath);
		imgWith = img.getWidth();
		imgHeight = img.getHeight();
		
		width = Integer.MAX_VALUE;
		height = Integer.MAX_VALUE;
	}
	

	@Override
	protected int getBackgroundRGBA(int x, int y) {
		x = x % imgWith;
		y = y % imgHeight;
		return img.getRGBA(x, y);
	}

}
