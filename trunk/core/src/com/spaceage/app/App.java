package com.spaceage.app;

import com.spaceage.core.platform.Platform;
import com.spaceage.core.platform.PlatformFactory;
import com.spaceage.core.platform.SceneRender;

public class App {
	
	Level_01 level;
	SceneRender render;
	
	public App(PlatformFactory factory) {
		
		Platform.factory = factory;
		
		level = new Level_01();
		
	}
	
	public void setRender(SceneRender render) {
		this.render = render;
		render.setScene(level.getScene());
	}

}
