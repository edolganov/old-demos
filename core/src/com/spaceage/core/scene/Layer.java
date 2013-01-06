package com.spaceage.core.scene;

import java.util.List;

import com.spaceage.app.G;
import com.spaceage.core.basic.Rectangle;
import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.tiles.FoundedTiles;
import com.spaceage.core.tiles.FoundedTiles.TileInfo;
import com.spaceage.core.tiles.TilesModel;
import com.spaceage.util.MathUtil;

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
		}
	}

	private void moveSprite(Sprite sprite, Window w) {
		
		ScenePoint startPoint = sprite.getStartPoint();
		
		int oldX = startPoint.getX();
		int oldY = startPoint.getY();
		
		startPoint.slowdownAccelerationX();
		startPoint.appendVelocity(0, G.gravityConst);
		startPoint.move();
		
		fixByTiles(oldX, oldY, sprite, w);
		
	}
	
	private void fixByTiles(int oldX, int oldY, Sprite sprite, Window w) {
		
		if(tiles == null){
			return;
		}
		
		ScenePoint startPoint = sprite.getStartPoint();
		
		//check x
		int x = startPoint.getX();
        int fromX = MathUtil.getMinVal(oldX, x);
        int width = MathUtil.getLength(oldX, x);
        Rectangle xRec = new Rectangle(fromX, oldY, width, 1);
		FoundedTiles tilesX = tiles.findTiles(xRec);
		if(tilesX.list.size() > 0){
			float velocityX = startPoint.getVelocityX();
			if(velocityX > 0){
				TileInfo firstTile = tilesX.list.get(0);
				startPoint.setX(firstTile.x - sprite.getWidth());
			} else {
				TileInfo lastTile = tilesX.list.get(tilesX.list.size()-1);
				startPoint.setX(lastTile.x + tilesX.tileWidth + 1);
			}
			startPoint.setVelocityX(0);
		}
		
		//check y
		int updatedX = startPoint.getX();
		int y = startPoint.getY();
		if(y >= 390){
			"".toString();
		}
        int fromY = MathUtil.getMinVal(oldY, y);
        int height = MathUtil.getLength(oldY, y);
        Rectangle yRec = new Rectangle(updatedX, fromY, 1, height);
		FoundedTiles tilesY = tiles.findTiles(yRec);
		if(tilesY.list.size() > 0){
			float velocityY = startPoint.getVelocityY();
			if(velocityY > 0){
				TileInfo firstTile = tilesY.list.get(0);
				startPoint.setY(firstTile.y - sprite.getHeight());
			} else {
				TileInfo lastTile = tilesY.list.get(tilesY.list.size()-1);
				startPoint.setY(lastTile.y + tilesY.tileHeight + 1);
			}
			startPoint.setVelocityY(0);
		}
		
	}



}
