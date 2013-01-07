package com.spaceage.app;

import com.spaceage.app.painter.Level1Painter;
import com.spaceage.core.G;
import com.spaceage.core.input.KeyManager;
import com.spaceage.core.input.KeyState;
import com.spaceage.core.layer.ImgLayer;
import com.spaceage.core.layer.TilesLayer;
import com.spaceage.core.platform.ActionCodes;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.SceneListener;
import com.spaceage.core.scene.ScenePoint;
import com.spaceage.core.scene.Sprite;
import com.spaceage.core.scene.SpritesContainer;

public class Level_01 implements SceneListener {
	
	private static final float PLAYER_APPEND_DX_VAL = 1f;
	Scene scene;
	Sprite player;
	boolean velocityXSet;
	
	KeyManager keymanager = G.keyManager;
	ActionCodes codes = G.actionCodes;
	
	
	public Level_01() {
		
		ImgLayer sky = new ImgLayer("/content/l01/sky.png");
		
		TilesLayer level = new TilesLayer(0, 0, new Level1Painter(), "/content/l01/level-1-model.png", 10, 10);
		SpritesContainer sprites = level.getSpriteContainer();
		
		player = sprites.createSprite("/content/l01/sprite-ex-01-1.png", 40, 300);
		ScenePoint playerPoint = player.getStartPoint();
		playerPoint.setMaxVelocityX(4);
		playerPoint.setMaxVelocityY(4);
		
		
		scene = new Scene();
		scene.add(sky);
		scene.add(level);
		scene.addListener(this);

		
		scene.setWindowVelocity(0, 0);
	}

	public Scene getScene() {
		return scene;
	}

	@Override
	public void beforeSceneUpdate() {
		
		ScenePoint playerPoint = player.getStartPoint();
		
		//left-right
		velocityXSet = false;
		
		if(keymanager.getState(codes.goRight()) == KeyState.PRESSED){
			playerPoint.appendVelocityX(PLAYER_APPEND_DX_VAL);
			velocityXSet = true;
		}
		
		if(keymanager.getState(codes.goLeft()) == KeyState.PRESSED){
			playerPoint.appendVelocityX(-PLAYER_APPEND_DX_VAL);
			velocityXSet = true;
		}
		
		if( ! velocityXSet){
			playerPoint.setVelocityX(0);
		}
		
		//jump
		if(keymanager.getState(codes.jump()) == KeyState.PRESSED){
			float curVelocityY = playerPoint.getVelocityY();
			if(curVelocityY >= 0){
				playerPoint.setVelocityY(-4);
			}
		}
		
		
		
	}

	@Override
	public void afterSceneUpdate() {
		
	}
	
	

}
