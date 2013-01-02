package com.spaceage.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.spaceage.app.App;
import com.spaceage.core.scene.Scene;

/** @see http://stackoverflow.com/questions/3256941 */
public class GamePanel extends JPanel {

    private static final int FRAMES = 24;
	
	App app;
	int width;
	int height;

    public GamePanel(App app, int width, int height) {
        super(true);
        this.app = app;
        this.width = width;
        this.height = height;
        
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
    	
    	long begin = System.currentTimeMillis();
    	
        super.paintComponent(g);
    	
    	Scene scene = app.getScene();
    	
		for(int x=0; x < width; ++x){
			for(int y=0; y < height; y++){
				int rgb = scene.getRGBA(x, y);
				g.setColor(new Color(rgb));
				g.drawLine(x, y, x, y);
			}
		}
		
        long end = System.currentTimeMillis() - begin;
        g.drawString("render: "+end+"ms", 5, 16);
    }
}