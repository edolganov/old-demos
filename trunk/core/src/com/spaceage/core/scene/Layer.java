package com.spaceage.core.scene;

import java.util.List;

import com.spaceage.app.G;
import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;

public abstract class Layer implements VisualObject {
	
	private SpritesContainer sprites = new SpritesContainer();
	
	
	public SpritesContainer getSpriteContainer() {
		return sprites;
	}
	
	@Override
	public void draw(Window window, GraphicsManager manager, Object platformGraphics) {
		drawBackgroud(window, manager, platformGraphics);
		drawSprites(window, manager, platformGraphics);
	}

	protected abstract void drawBackgroud(Window w, GraphicsManager manager, Object platformGraphics);
	
	
	private void drawSprites(Window window, GraphicsManager manager, Object platformGraphics) {
		
		List<Sprite> list = sprites.getList();
		if(list == null){
			return;
		}
		
		for(int i=0; i < list.size(); ++i){
			Sprite sprite = list.get(i);
			if(sprite.isVisible(window)){
				sprite.draw(window, manager, platformGraphics);
			}
		}
	}
	
	
	public void updateState() {
		List<Sprite> list = sprites.getList();
		if(list == null){
			return;
		}
		
		//move all sprites
		for(int i=0; i < list.size(); ++i){
			Sprite sprite = list.get(i);
			moveSprite(sprite);
		}
	}

	private void moveSprite(Sprite sprite) {
		ScenePoint startPoint = sprite.getStartPoint();
		startPoint.slowdownAccelerationX();
		startPoint.appendVelocity(0, G.gravityConst());
		startPoint.move();
	}

}
