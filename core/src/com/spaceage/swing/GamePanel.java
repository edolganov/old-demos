package com.spaceage.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.spaceage.app.App;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Scene;
import com.spaceage.swing.platform.ImageImpl;

/** @see http://stackoverflow.com/questions/3256941 */
public class GamePanel extends JPanel implements GraphicsManager {
	
	App app;
	int width;
	int height;

    public GamePanel(App app, int width, int height) {
        super(true);
        this.app = app;
        this.width = width;
        this.height = height;
        
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
    	
    	long begin = System.currentTimeMillis();
    	
        super.paintComponent(g);
    	
    	Scene scene = app.getScene();
    	scene.draw(this, g);
		
    	g.setColor(new Color(0x33000000, true));
    	g.fillRect(0, 0, 170, 40);
    	g.setColor(Color.WHITE);
        
    	long renderTime = System.currentTimeMillis() - begin;
    	String renderTimeStr = "render: "+renderTime+"ms";
        
        int maxFPS = (int)(1000/(double)renderTime);
        String maxFPSStr = "maxFPS: "+ (maxFPS > 1000? "1000+" : maxFPS);
		g.drawString(renderTimeStr+", "+maxFPSStr, 5, 16);
        g.drawString("position: ["+scene.getWIndowX()+","+scene.getWindowY()+"]", 5, 32);
    }

	@Override
	public void draw(Image image, int imageStartX, int imageStartY, Object platformGraphics) {
		Graphics g = (Graphics) platformGraphics;
		ImageImpl imageImpl = (ImageImpl) image;
		BufferedImage bufferedImage = imageImpl.getBufferedImage();
		g.drawImage(bufferedImage, imageStartX, imageStartY, null);
		
	}
}