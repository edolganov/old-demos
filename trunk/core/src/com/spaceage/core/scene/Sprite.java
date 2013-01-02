package com.spaceage.core.scene;

import java.util.ArrayList;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.Platform;
import com.spaceage.util.Util;

public class Sprite extends AbstractVisualObject {
	
	private String id;
	private ArrayList<Image> images;
	
	public Sprite() {
		id = Util.randomUUID();
	}
	
	public Sprite(String resourcePath){
		this();
		
		Image img = Platform.factory.createImage(resourcePath);
		
		//single img
		images = new ArrayList<Image>();
		images.add(img);
		width = img.getWidth();
		height = img.getHeight();
		
	}

	public String getId() {
		return id;
	}

	@Override
	public int getRGBA(int x, int y) {
		
		if(Util.isEmpty(images)){
			return 0;
		}
		
		//single img
		if(images.size() == 1){
			return images.get(0).getRGBA(x, y);
		}
		
		//animated sprite
		//TODO
		return 0;
	}
	
}
