package com.spaceage.app;

import com.spaceage.component.layer.img.ImgLayer;
import com.spaceage.core.scene.Scene;

public class Level_01 {
	
	private Scene scene;
	
	public Level_01() {
		
		scene = new Scene();
		scene.add(new ImgLayer("/content/l01/sky.png"));
		
	}

	public Scene getScene() {
		return scene;
	}
	
	

}
