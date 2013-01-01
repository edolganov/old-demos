package com.spaceage.component.layer.img;

import java.io.InputStream;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.Platform;
import com.spaceage.core.scene.Layer;

public class ImgLayer extends Layer {
	
	Image img;
	int width;
	int height;
	
	public ImgLayer(String resourcePath) {
		img = loadImg(resourcePath);
		width = img.getWidth();
		height = img.getHeight();
	}


	private Image loadImg(String resourcePath) {
		InputStream is = getClass().getResourceAsStream(resourcePath);
		return Platform.factory.createImage(is);
	}
	

	@Override
	public int getRGBA(int x, int y) {
		x = x % width;
		y = y % height;
		return img.getRGB(x, y);
	}

}
