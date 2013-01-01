package com.spaceage.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.spaceage.core.ui.RGB;
import com.spaceage.core.ui.World;

public class WorldPanel extends JPanel {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				World world = new World();
				WorldPanel panel = new WorldPanel(world);
				
				JFrame frame = new JFrame("test space-age");
				frame.setMinimumSize(new Dimension(1024, 768));
				frame.add(panel);
				frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				
			}
		});
		
	}
	
	World world;
	int width = 1024;
	int height = 768;
	BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	public WorldPanel(World world) {
		super();
		this.world = world;
	}
	
	@Override
	public void paint(Graphics g) {
		
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				RGB rgb = world.getRGB(x,y);
				g.setColor(new Color(rgb.r, rgb.g, rgb.b));
				g.drawLine(x, y, x, y);
				
			}
		}

	}
	
	

}
