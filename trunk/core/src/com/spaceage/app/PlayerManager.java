package com.spaceage.app;

import com.spaceage.core.G;
import com.spaceage.core.input.KeyManager;
import com.spaceage.core.input.KeyState;
import com.spaceage.core.platform.ActionCodes;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.SceneListener;
import com.spaceage.core.scene.ScenePoint;
import com.spaceage.core.scene.Sprite;
import com.spaceage.core.scene.SpriteListener;

public class PlayerManager implements SceneListener, SpriteListener {
	
	private static final float PLAYER_APPEND_DX_VAL = 1f;
	private static final int MAX_DY = 8;
	private static final int MAX_DX = 4;
	
	KeyManager keymanager = G.keyManager;
	ActionCodes codes = G.actionCodes;
	
	Scene scene;
	Sprite player;
	
	boolean velocityXSet;
	boolean canJump;
	
	public PlayerManager(Scene scene, Sprite player) {
		super();
		this.scene = scene;
		this.player = player;
		
		scene.addListener(this);
		player.addListener(this);
		
		ScenePoint playerPoint = player.getStartPoint();
		playerPoint.setMaxVelocityX(MAX_DX);
		playerPoint.setMaxVelocityY(MAX_DY);
		
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
			if(canJump){
				playerPoint.setVelocityY(-MAX_DY);
			}
		}
		
		
		
	}

	@Override
	public void afterSceneUpdate() {
		
	}

	@Override
	public void onTileCollision(Direciton direciton) {
		if(direciton == Direciton.DOWN){
			canJump = true;
		}
	}

	@Override
	public void onNoTileCollision() {
		canJump = false;
	}
	
	

}
