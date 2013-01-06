package com.spaceage.swing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.spaceage.app.App;
import com.spaceage.core.basic.Window;
import com.spaceage.swing.platform.PlatformFactoryImpl;

public class SwingApp implements ActionListener{
	
	App app;
	JFrame window;
	GamePanel gamePanel;
    Timer timer = new Timer(20, this);
    
    public SwingApp() {
		int width = 640;
		int height = 480;
		App app = new App(new PlatformFactoryImpl(), new Window(0, 0, width, height));
		init(app, width, height);
	}
	
	
	public SwingApp(App app, int width, int height) {
		init(app, width, height);
	}

	private void init(App app, int width, int height) {

		this.app = app;
		
		window = new JFrame("space-age");
		window.setIgnoreRepaint(true);
		window.setLocation(new Point(480, 240));
		window.setResizable(false);		
		Dimension size = new Dimension(width+8, height+27);
		window.setSize(size);
		window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		gamePanel = new GamePanel(app, width, height);
		window.add(gamePanel);
		window.pack();
		window.setLocationRelativeTo(null);
		
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


	public void start() {
		window.setVisible(true);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.getScene().updateScene();
		gamePanel.repaint();
	}

}
