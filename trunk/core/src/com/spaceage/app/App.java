package com.spaceage.app;

import com.spaceage.core.ui.SceneRender;

public class App {
	
	Level_01 level;
	SceneRender render;
	
	public App() {
		
		level = new Level_01();
		
	}
	
	public void setRender(SceneRender render) {
		this.render = render;
		render.setScene(level.getScene());
	}

}
