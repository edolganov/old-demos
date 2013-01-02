package com.spaceage.swing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.spaceage.app.App;
import com.spaceage.core.scene.timer.SceneListener;
import com.spaceage.core.scene.timer.SceneUpdater;

public class SwingApp {
	
	JFrame window;
	ScenePanel scenePanel;
	SceneListenerImpl sceneListener;
	
	
	public SwingApp(App app) {
		window = new JFrame("space-age");
		
		window.setLocation(new Point(480, 240));
		
		int width = 640;
		int height = 480;
		Dimension size = new Dimension(width+8, height+27);
		window.setMinimumSize(size);
		window.setMaximumSize(size);
		
		window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//scene panel
		scenePanel = new ScenePanel(width, height);
		app.setRender(scenePanel);
		window.add(scenePanel);
		
		//update listener
		sceneListener = new SceneListenerImpl(this);
		app.setSceneListener(sceneListener);
		
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
	
	private void repaintScene() {
		scenePanel.repaint();
	}

	public void start() {
		window.pack();
		window.setVisible(true);
	}

	
	private static final class SceneListenerImpl implements SceneListener, Runnable {
		
		final SwingApp owner;
		volatile SceneUpdater sceneUpdater;

		public SceneListenerImpl(SwingApp owner) {
			super();
			this.owner = owner;
		}

		@Override
		public void onUpdateRequest(SceneUpdater sceneUpdater) {
			this.sceneUpdater = sceneUpdater;
			SwingUtilities.invokeLater(this);
		}
		
		/**
		 * for EventQueue thread only
		 */
		@Override
		public void run() {
			SceneUpdater curUpdater = sceneUpdater;
			if(curUpdater != null){
				curUpdater.updateScene();
				owner.repaintScene();
			}
			
		}
		
	}

}
