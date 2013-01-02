package com.spaceage.app;

import com.spaceage.core.platform.PlatformFactory;
import com.spaceage.core.platform.SceneRender;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.timer.SceneListener;

public class App {
	
	Level_01 level;
	Scene scene;
	SceneRender render;
	SceneListener sceneListener;
	
	public App(PlatformFactory factory) {
		
		Global.factory = factory;
		
		level = new Level_01();
		scene = level.getScene();
		
	}
	
	
	
	public void setSceneListener(SceneListener sceneListener) {
		this.sceneListener = sceneListener;
		linkListenerToScene();
	}


	private void linkListenerToScene() {
		if(scene != null){
			scene.setUpdateSceneListener(sceneListener);
		}
	}



	public void setRender(SceneRender render) {
		this.render = render;
		render.setScene(scene);
	}
	
	public void start(){
		int delay = 100;
		int period = 34; //30fps
		scene.start(delay, period);
	}

}
