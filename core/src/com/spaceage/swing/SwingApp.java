package com.spaceage.swing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.spaceage.app.App;

public class SwingApp {
	
	JFrame window;
	
	
	
	public SwingApp(App app) {
		window = new JFrame("space-age");
		
		window.setLocation(new Point(480, 240));
		
		Dimension size = new Dimension(640, 480);
		window.setMinimumSize(size);
		window.setMaximumSize(size);
		
		window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		ScenePanel scenePanel = new ScenePanel();
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
			}
		});
	}


	public void start() {
		window.pack();
		window.setVisible(true);
	}

}
