package com.spaceage.app;

import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.PlatformFactory;
import com.spaceage.core.scene.Scene;

public class App {
	
	Level_01 level;
	Scene scene;
	
	public App(PlatformFactory factory, Window window) {
		
		G.factory = factory;
		G.initialWindow = new Window(window);
		
		level = new Level_01();
		scene = level.getScene();
		
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	
	
	

}
