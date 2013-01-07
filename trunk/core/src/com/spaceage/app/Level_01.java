package com.spaceage.app;

import com.spaceage.app.painter.Level1Painter;
import com.spaceage.core.layer.ImgLayer;
import com.spaceage.core.layer.TilesLayer;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.Sprite;
import com.spaceage.core.scene.SpritesContainer;

public class Level_01 {
	
	Scene scene;
	
	public Level_01() {
		
		ImgLayer sky = new ImgLayer("/content/l01/sky.png");
		
		TilesLayer level = new TilesLayer(0, 0, new Level1Painter(), "/content/l01/level-1-model.png", 10, 10);
		SpritesContainer sprites = level.getSpriteContainer();
		
		Sprite player = sprites.createSprite("/content/l01/sprite-ex-01-1.png", 40, 300);
		
		scene = new Scene();
		scene.add(sky);
		scene.add(level);
		
		new PlayerManager(scene, player);
	}

	public Scene getScene() {
		return scene;
	}
	
	

}
