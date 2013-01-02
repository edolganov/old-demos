package com.spaceage.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.spaceage.core.platform.SceneRender;
import com.spaceage.core.scene.AbstractVisualObject;

public class ScenePanel extends JPanel implements SceneRender {
	
	SwingApp owner;
	AbstractVisualObject scene;
	int width;
	int height;

	public ScenePanel(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void setScene(AbstractVisualObject scene) {
		this.scene = scene;
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		if(scene == null){
			return;
		}
		
		for(int x=0; x < width; ++x){
			for(int y=0; y < height; y++){
				int rgb = scene.getRGBA(x, y);
				g.setColor(new Color(rgb));
				g.drawLine(x, y, x, y);
				
			}
		}

	}


	
	

}
