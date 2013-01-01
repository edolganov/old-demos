package com.spaceage.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.spaceage.core.ui.Scene;
import com.spaceage.example.ImgLayer;

public class ScenePanel extends JPanel {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				Scene world = new Scene();
				world.add(new ImgLayer("/content/sky.jpg"));
				world.add(new ImgLayer("/content/mountains.png"));
				world.add(new ImgLayer("/content/road.png"));
				
				
				ScenePanel panel = new ScenePanel(world);
				
				JFrame frame = new JFrame("test space-age");
				frame.setMinimumSize(new Dimension(640, 480));
				frame.add(panel);
				frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
				frame.pack();
				frame.setLocation(new Point(480, 240));
				frame.setVisible(true);
				
			}
		});
		
	}
	
	Scene world;
	int width = 640;
	int height = 480;
	BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	public ScenePanel(Scene world) {
		super();
		this.world = world;
	}
	
	@Override
	public void paint(Graphics g) {
		
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				int rgb = world.getRGB(x,y);
				g.setColor(new Color(rgb));
				g.drawLine(x, y, x, y);
				
			}
		}

	}
	
	

}
