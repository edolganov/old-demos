package com.spaceage.component.layer.img;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.spaceage.core.scene.Layer;

public class ImgLayer extends Layer {
	
	BufferedImage img;
	int width;
	int height;
	
	public ImgLayer(String resourcePath) {
		img = loadImg(resourcePath);
		width = img.getWidth();
		height = img.getHeight();
	}


	private BufferedImage loadImg(String resourcePath) {
		InputStream is = getClass().getResourceAsStream(resourcePath);
		try {
			return ImageIO.read(is);
		} catch (IOException e) {
			throw new IllegalStateException("can't load image", e);
		}
	}
	

	@Override
	public int getRGBA(int x, int y) {
		x = x % width;
		y = y % height;
		return img.getRGB(x, y);
	}

}
