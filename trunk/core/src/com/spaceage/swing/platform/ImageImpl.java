package com.spaceage.swing.platform;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.spaceage.core.platform.Image;

public class ImageImpl extends Image {

	BufferedImage bufferedImage;
	
	public ImageImpl(InputStream is) {
		try {
			bufferedImage = ImageIO.read(is);
		} catch (IOException e) {
			throw new IllegalStateException("can't load image", e);
		}
	}
	
	public ImageImpl(int width, int height) {
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	@Override
	public void setRGBA(int x, int y, int rgba) {
		bufferedImage.setRGB(x, y, rgba);
	}

	@Override
	public int getRGBA(int x, int y) {
		return bufferedImage.getRGB(x, y);
	}
	
	public BufferedImage getBufferedImage(){
		return bufferedImage;
	}

	@Override
	public int getWidth() {
		return bufferedImage.getWidth();
	}

	@Override
	public int getHeight() {
		return bufferedImage.getHeight();
	}




	
	

}
