package com.spaceage.app;

import com.spaceage.core.platform.PlatformFactory;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.Window;

public class App {
	
	Level_01 level;
	Scene scene;
	
	public App(PlatformFactory factory, Window window) {
		
		Global.factory = factory;
		Global.initialWindow = new Window(window);
		
		level = new Level_01();
		scene = level.getScene();
		
	}

	public Scene getScene() {
		return scene;
	}
	
	

}
