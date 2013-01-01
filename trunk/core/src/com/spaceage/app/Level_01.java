package com.spaceage.app;

import com.spaceage.component.layer.ImgLayer;
import com.spaceage.component.layer.MaskLayer;
import com.spaceage.core.scene.Scene;

public class Level_01 {
	
	private Scene scene;
	
	public Level_01() {
		
		scene = new Scene();
		scene.add(new ImgLayer("/content/l01/sky.png"));
		scene.add(new MaskLayer("/content/l01/l01-model.png"));
		
	}

	public Scene getScene() {
		return scene;
	}
	
	

}
