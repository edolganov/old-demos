package com.spaceage.swing.platform;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.spaceage.core.platform.Image;

public class ImageImpl implements Image {

	BufferedImage bufferedImage;
	
	public ImageImpl(InputStream is) {
		try {
			bufferedImage = ImageIO.read(is);
		} catch (IOException e) {
			throw new IllegalStateException("can't load image", e);
		}
	}

	@Override
	public int getWidth() {
		return bufferedImage.getWidth();
	}

	@Override
	public int getHeight() {
		return bufferedImage.getHeight();
	}

	@Override
	public int getRGB(int x, int y) {
		return bufferedImage.getRGB(x, y);
	}
	
	

}
