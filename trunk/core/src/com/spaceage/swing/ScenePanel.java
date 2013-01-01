package com.spaceage.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.spaceage.core.platform.SceneImage;
import com.spaceage.core.platform.SceneRender;

public class ScenePanel extends JPanel implements SceneRender {
	
	SceneImage scene;
	int width = 640;
	int height = 480;

	public ScenePanel() {
		super();
	}
	
	@Override
	public void setScene(SceneImage scene) {
		this.scene = scene;
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		if(scene == null){
			return;
		}
		
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				int rgb = scene.getRGB(x,y);
				g.setColor(new Color(rgb));
				g.drawLine(x, y, x, y);
				
			}
		}

	}


	
	

}
