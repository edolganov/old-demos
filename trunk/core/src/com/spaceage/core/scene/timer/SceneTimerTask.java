package com.spaceage.core.scene.timer;

import java.util.TimerTask;

import com.spaceage.core.scene.Scene;

public class SceneTimerTask extends TimerTask {
	
	Scene scene;

	public SceneTimerTask(Scene scene) {
		super();
		this.scene = scene;
	}
	
	
	@Override
	public void run() {
		scene.nextStateReq();
	}

}
