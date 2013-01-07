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
	private static final int WALK_DX = 4;
	private static final int JUMP_DY = 8;
	
	KeyManager keymanager = G.keyManager;
	ActionCodes codes = G.actionCodes;
	
	int winWidth = G.initialWindow.width;
	int winRightEdge = (int)(winWidth * 0.8);
	int winLeftEdge = (int)(winWidth * 0.2);
	
	int winHeigth = G.initialWindow.height;
	int winUpEdge = (int)(winHeigth * 0.2);
	int winDownEdge = (int)(winHeigth * 0.8);
	
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
		playerPoint.setMaxVelocityX(WALK_DX);
		
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
				playerPoint.setVelocityY(-JUMP_DY);
			}
		}
		
		
		
	}

	@Override
	public void afterSceneUpdate() {
		
		ScenePoint playerPoint = player.getStartPoint();
		ScenePoint windowPoint = scene.getWindowStartPoint();
		
		int winX = windowPoint.getX();
		int localX = playerPoint.getX() - winX;
		int velocityX = Math.abs((int)playerPoint.getVelocityX());
		if(localX >= winRightEdge){
			windowPoint.setX(winX+velocityX);
		}
		else if(localX <= winLeftEdge && winX > 0){
			windowPoint.setX(winX-velocityX);
		}
		
//		int winY = windowPoint.getY();
//		int localY = playerPoint.getY() - winY;
//		int velocityY = Math.abs((int)playerPoint.getVelocityY());
//		if(localY >= winDownEdge && winY <= 0){
//			windowPoint.setY(winY+velocityY);
//		} else if(localY <= winUpEdge ){
//			windowPoint.setY(winY-velocityY);
//		}
		
		
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
