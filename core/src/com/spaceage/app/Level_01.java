package com.spaceage.app;

import com.spaceage.core.layer.ImgLayer;
import com.spaceage.core.layer.MaskLayer;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.Sprite;
import com.spaceage.core.scene.SpritesContainer;

public class Level_01 {
	
	private Scene scene;
	
	public Level_01() {
		
		ImgLayer sky = new ImgLayer("/content/l01/sky.png");
		
		MaskLayer level = new MaskLayer("/content/l01/l01-model.png");
		SpritesContainer sprites = level.getSpriteContainer();
		
		Sprite player = sprites.createSprite("/content/l01/sprite-ex-01-1.png", 10, 280);
		sprites.createSprite("/content/l01/sprite-ex-02-1.png", 30, 330);
		sprites.createSprite("/content/l01/sprite-ex-02-1.png", 600, 420);
		
		
		scene = new Scene();
		scene.add(sky);
		scene.add(level);
		
		player.setVelocity(20, 0);
		scene.setWindowVelocity(20, 0);
	}

	public Scene getScene() {
		return scene;
	}
	
	

}
