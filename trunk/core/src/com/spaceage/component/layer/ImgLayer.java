package com.spaceage.component.layer;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.Platform;
import com.spaceage.core.scene.Layer;

public class ImgLayer extends Layer {
	
	Image img;
	int width;
	int height;
	
	public ImgLayer(String resourcePath) {
		img = Platform.factory.createImage(resourcePath);
		width = img.getWidth();
		height = img.getHeight();
	}
	

	@Override
	public int getRGBA(int x, int y) {
		x = x % width;
		y = y % height;
		return img.getRGBA(x, y);
	}

}
