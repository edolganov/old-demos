package com.spaceage.core.scene;

import java.util.List;

import com.spaceage.core.G;
import com.spaceage.core.basic.Rectangle;
import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.scene.SpriteListener.Direciton;
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
		
		int width = sprite.getWidth();
		int height = sprite.getHeight();
		
		//check x
		SpriteListener.Direciton collisionDirectionX = null;
		int x = startPoint.getX();
		float velocityX = startPoint.getVelocityX();
		if(velocityX > 0){
			int oldEndX = oldX + width;
			int newEndX = x + width;
			int fromX = MathUtil.getMinVal(oldEndX, newEndX);
			int recWidth = MathUtil.getLength(oldEndX, newEndX);
			FoundedTiles tilesX = tiles.findTiles(new Rectangle(fromX, oldY, recWidth, height));
			if( ! tilesX.isEmpty()){
				TileInfo firstTile = tilesX.findMinByX();
				startPoint.setX(firstTile.x - width - 1);
				startPoint.setVelocityX(0);
				collisionDirectionX = Direciton.RIGHT;
			}
		} else {
			int fromX = MathUtil.getMinVal(oldX, x);
			int recWidth = MathUtil.getLength(oldX, x);
			FoundedTiles tilesX = tiles.findTiles(new Rectangle(fromX, oldY, recWidth, height));
			if(! tilesX.isEmpty()){
				TileInfo lastTile =  tilesX.findMaxByX();
				startPoint.setX(lastTile.x + tilesX.tileWidth + 1);
				startPoint.setVelocityX(0);
				collisionDirectionX = Direciton.LEFT;
			}
		}
		
		if(collisionDirectionX != null){
			List<SpriteListener> listeners = sprite.getListeners();
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).onTileCollision(collisionDirectionX);
			}
		}
		
		//check y
		SpriteListener.Direciton collisionDirectionY = null;
		int updatedX = startPoint.getX();
		int y = startPoint.getY();
		float velocityY = startPoint.getVelocityY();
		if(velocityY > 0){

			int oldEndY = oldY + height;
			int newEndY = y + height;
			int fromY = MathUtil.getMinVal(oldEndY, newEndY);
			int recHeight = MathUtil.getLength(oldEndY, newEndY);
			FoundedTiles tilesY = tiles.findTiles(new Rectangle(updatedX, fromY, width, recHeight));
			if( ! tilesY.isEmpty()){
				TileInfo firstTile = tilesY.findMinByY();
				startPoint.setY(firstTile.y - height - 1);
				startPoint.setVelocityY(0);
				collisionDirectionY = Direciton.DOWN;
			}
		} else {
			int fromY = MathUtil.getMinVal(oldY, y);
			int recHeight = MathUtil.getLength(oldY, y);
			FoundedTiles tilesY = tiles.findTiles(new Rectangle(updatedX, fromY, width, recHeight));
			if( ! tilesY.isEmpty()){
				TileInfo lastTile = tilesY.findMaxByY();
				startPoint.setY(lastTile.y + tilesY.tileHeight + 1);
				startPoint.setVelocityY(0);
				collisionDirectionY = Direciton.UP;
			}
		}
		
		if(collisionDirectionY != null){
			List<SpriteListener> listeners = sprite.getListeners();
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).onTileCollision(collisionDirectionY);
			}
		}
		
		if(collisionDirectionX == null && collisionDirectionY == null){
			List<SpriteListener> listeners = sprite.getListeners();
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).onNoTileCollision();
			}
		}


		
	}



}
