package com.spaceage.swing;

import javax.swing.SwingUtilities;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				SwingApp swingApp = new SwingApp();
				swingApp.start();
			}
		});
		
	}

}
