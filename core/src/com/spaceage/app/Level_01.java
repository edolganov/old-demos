package com.spaceage.app;

import com.spaceage.component.layer.ImgLayer;
import com.spaceage.component.layer.MaskLayer;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.Sprite;

public class Level_01 {
	
	private Scene scene;
	
	public Level_01() {
		
		ImgLayer sky = new ImgLayer("/content/l01/sky.png");
		
		MaskLayer level = new MaskLayer("/content/l01/l01-model.png");
		level.addSprite(new Sprite("/content/l01/sprite-ex-01-1.png"), 10, 280);
		level.addSprite(new Sprite("/content/l01/sprite-ex-02-1.png"), 30, 330);
		level.addSprite(new Sprite("/content/l01/sprite-ex-02-1.png"), 600, 420);
		
		scene = new Scene();
		scene.add(sky);
		scene.add(level);
		
	}

	public Scene getScene() {
		return scene;
	}
	
	

}
