package com.spaceage.app;

import com.spaceage.component.layer.ImgLayer;
import com.spaceage.component.layer.MaskLayer;
import com.spaceage.core.scene.Scene;

public class Level_01 {
	
	private Scene scene;
	
	public Level_01() {
		
		ImgLayer sky = new ImgLayer("/content/l01/sky.png");
		
		MaskLayer level = new MaskLayer("/content/l01/l01-model.png");
		
		scene = new Scene();
		scene.add(sky);
		scene.add(level);
		
	}

	public Scene getScene() {
		return scene;
	}
	
	

}
