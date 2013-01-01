package com.spaceage.swing;

import javax.swing.SwingUtilities;

import com.spaceage.app.App;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				App app = new App();
				
				SwingApp swingApp = new SwingApp(app);
				swingApp.start();
			}
		});
		
	}

}
