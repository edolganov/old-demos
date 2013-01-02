package com.spaceage.swing.test;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.spaceage.app.App;
import com.spaceage.core.scene.Scene;
import com.spaceage.swing.platform.PlatformFactoryImpl;

public class FullScreenTest {

    public static void main(String args[]) {
        FullScreenTest test = new FullScreenTest();
        test.run();
    }

    private static final DisplayMode POSSIBLE_MODES[] = {
        new DisplayMode(800, 600, 32, 0),
        new DisplayMode(800, 600, 24, 0),
        new DisplayMode(800, 600, 16, 0),
        new DisplayMode(640, 480, 32, 0),
        new DisplayMode(640, 480, 24, 0),
        new DisplayMode(640, 480, 16, 0)
    };

    private static final long DEMO_TIME = 10000;

    private ScreenManager screen;
    App app;
    DisplayMode displayMode;

    public void run() {
    	
		app = new App(new PlatformFactoryImpl());
		
        screen = new ScreenManager();
        try {
            displayMode = screen.findFirstCompatibleMode(POSSIBLE_MODES);
            screen.setFullScreen(displayMode);
            animationLoop();
        }
        finally {
            screen.restoreScreen();
        }
    }


    public void animationLoop() {
        long startTime = System.currentTimeMillis();
        long currTime = startTime;

        while (currTime - startTime < DEMO_TIME) {
            long elapsedTime =
                System.currentTimeMillis() - currTime;
            currTime += elapsedTime;

            // update animation
            Scene scene = app.getScene();
            scene.updateScene();

            // draw and update screen
            Graphics2D g = screen.getGraphics();
            draw(g);
            g.dispose();
            screen.update();

            // take a nap
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException ex) { }
        }

    }


    public void draw(Graphics g) {
        
    	Scene scene = app.getScene();
    	int width = displayMode.getWidth();
    	int height = displayMode.getHeight();
    	
		for(int x=0; x < width; ++x){
			for(int y=0; y < height; y++){
				int rgb = scene.getRGBA(x, y);
				g.setColor(new Color(rgb));
				g.drawLine(x, y, x, y);
			}
		}
		
    }

}
