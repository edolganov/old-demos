package com.spaceage.swing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.spaceage.app.App;

public class SwingApp {
	
	JFrame window;
	ScenePanel scenePanel;
	
	
	public SwingApp(App app) {
		window = new JFrame("space-age");
		
		window.setLocation(new Point(480, 240));
		
		int width = 640;
		int height = 480;
		Dimension size = new Dimension(width+8, height+27);
		window.setMinimumSize(size);
		window.setMaximumSize(size);
		
		window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		scenePanel = new ScenePanel(width, height);
		app.setRender(scenePanel);
		window.add(scenePanel);
		
		window.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				//<- 37, -> 39, up - 38, down - 40
				if(keyCode == 37){
				}
				else if(keyCode == 39){
				}
				
			}
		});
	}
	
	private void repaintReq() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				scenePanel.repaint();
			}
		});
		
	}






	public void start() {
		window.pack();
		window.setVisible(true);
	}

}
