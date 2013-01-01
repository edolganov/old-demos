package com.spaceage.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.spaceage.core.platform.SceneImage;
import com.spaceage.core.platform.SceneRender;

public class ScenePanel extends JPanel implements SceneRender {
	
	SwingApp owner;
	SceneImage scene;
	int width;
	int height;

	public ScenePanel(SwingApp owner, int width, int height) {
		this.owner = owner;
		this.width = width;
		this.height = height;
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
			for(int y=0; y < height; y++){
				int sceneX = x + owner.getOffsetX();
				int sceneY = y + owner.getOffsetY();
				int rgb = scene.getRGB(sceneX, sceneY);
				g.setColor(new Color(rgb));
				g.drawLine(x, y, x, y);
				
			}
		}

	}


	
	

}
