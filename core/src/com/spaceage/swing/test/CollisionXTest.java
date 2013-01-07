package com.spaceage.swing.test;

import javax.swing.SwingUtilities;

import com.spaceage.app.G;
import com.spaceage.app.painter.Level1Painter;
import com.spaceage.core.layer.TilesLayer;
import com.spaceage.core.scene.Scene;
import com.spaceage.core.scene.Sprite;
import com.spaceage.core.scene.SpritesContainer;
import com.spaceage.swing.SwingApp;

public class CollisionXTest {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				SwingApp app = new SwingApp(null, false);
				G.gravityConst = 0;
				
				TilesLayer level = new TilesLayer(0, 0, new Level1Painter(), "/content/l01/level-1-model.png", 10, 10);
				SpritesContainer sprites = level.getSpriteContainer();
				
				Sprite player = sprites.createSprite("/content/l01/sprite-ex-01-1.png", 140, 300);
				player.getStartPoint().setVelocity(2, 0);
				
				Scene scene = new Scene();
				scene.add(level);
				app.getApp().setScene(scene);

				app.start();
				
				
			}
		});
		
	}
	

}
