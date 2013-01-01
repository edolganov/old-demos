package com.spaceage.swing;

import javax.swing.SwingUtilities;

import com.spaceage.app.App;
import com.spaceage.core.platform.Platform;
import com.spaceage.swing.platform.PlatformFactoryImpl;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				Platform.factory = new PlatformFactoryImpl();
				
				App app = new App();
				
				SwingApp swingApp = new SwingApp(app);
				swingApp.start();
			}
		});
		
	}

}
