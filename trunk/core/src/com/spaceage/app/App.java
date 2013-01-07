package com.spaceage.app;

import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.PlatformFactory;
import com.spaceage.core.scene.Scene;

public class App {
	
	Scene scene;
	
	public App(PlatformFactory factory, Window window) {
		this(factory, window, null, true);
	}
	
	
	public App(PlatformFactory factory, Window window, Scene scene, boolean createDefaultScene) {
		
		G.factory = factory;
		G.initialWindow = new Window(window);
		
		if(scene == null && createDefaultScene){
			Level_01 level = new Level_01();
			this.scene = level.getScene();
		} else {
			this.scene = scene;
		}

		
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	
	
	

}
