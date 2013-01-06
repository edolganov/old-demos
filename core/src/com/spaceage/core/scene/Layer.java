package com.spaceage.core.scene;

import java.util.ArrayList;
import java.util.List;

import com.spaceage.app.G;
import com.spaceage.core.basic.Rectangle;
import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.tiles.FoundedTiles;
import com.spaceage.core.tiles.FoundedTiles.TileInfo;
import com.spaceage.core.tiles.TilesModel;

public abstract class Layer implements VisualObject {
	
	protected SpritesContainer sprites = new SpritesContainer();
	protected TilesModel tiles;
	
	
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
	
	
	public void updateState(Window w) {
		List<Sprite> list = sprites.getList();
		if(list == null){
			return;
		}
		
		//move all sprites
		for(int i=0; i < list.size(); ++i){
			Sprite sprite = list.get(i);
			moveSprite(sprite, w);
			fixByTiles(sprite, w);
		}
	}

	private void moveSprite(Sprite sprite, Window w) {
		
		ScenePoint startPoint = sprite.getStartPoint();
		startPoint.slowdownAccelerationX();
		startPoint.appendVelocity(0, G.gravityConst());
		startPoint.move();
		
	}
	
	private void fixByTiles(Sprite sprite, Window w) {
		
		if(tiles == null){
			return;
		}
		
		ScenePoint startPoint = sprite.getStartPoint();
			
		int x = startPoint.getX();
		int y = startPoint.getY();
		int width = sprite.getWidth();
		int height = sprite.getHeight();
		
		Rectangle rec = new Rectangle(x, y, width, height);
		FoundedTiles founded = tiles.findTiles(rec);
		ArrayList<TileInfo> list = founded.list;
		if(list.size() == 0){
			return;
		}
		
		float velocityX = startPoint.getVelocityX();
		float velocityY = startPoint.getVelocityY();
		
	}

}
