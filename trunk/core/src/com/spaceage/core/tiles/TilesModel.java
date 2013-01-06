package com.spaceage.core.tiles;

import java.util.ArrayList;

import com.spaceage.core.basic.Rectangle;
import com.spaceage.core.tiles.FoundedTiles.TileInfo;

public class TilesModel {
	
	public static final int EMPTY = 0; 
	public static final int GROUND = 1;
	
	int offsetX;
	int offsetY;
	byte[][] matrix;
	int tileWidth;
	int tileHeight;
	int matrixWidth;
	int matrixHeight;
	
	public TilesModel(int offsetX, int offsetY, int matrixWidth, int matrixHeight, int tileWidth, int tileHeight) {
		matrix = new byte[matrixWidth][matrixHeight];
		this.matrixWidth = matrixWidth;
		this.matrixHeight = matrixHeight;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	public void setGround(int modelX, int modelY) {
		matrix[modelX][modelY] = GROUND;
	}
	
	public FoundedTiles findTiles(Rectangle rec){
		
		final ArrayList<TileInfo> tiles = new ArrayList<TileInfo>();
		findTiles(rec, new FindTilesListener() {
			
			@Override
			public void onFoundTile(int x, int y, int width, int height, byte state) {
				tiles.add(new TileInfo(x, y, state));
			}
		});
		
		return new FoundedTiles(tiles, tileWidth, tileHeight);
		
		
	}
	
	
	public void findTiles(Rectangle rec, FindTilesListener listener){
		

		int localX = rec.x - offsetX;
		int positiveX = getPositiveX(localX);
		int recWidth = getRecWidth(localX, rec.width);
		int endX = positiveX + recWidth;
		int stepsX = positiveX / tileWidth;
		int startX = tileWidth * stepsX;
		int modelX = stepsX;
		
		int localY = rec.y - offsetY;
		int positiveY = getPositiveY(localY);
		int recHeight = getRecHeight(localY, rec.height);
		int endY = positiveY + recHeight;
		int stepsY = positiveY / tileHeight;
		int startY;
		int modelY;
		

		int tileX;
		int tileY;
		while(startX <= endX && modelX < matrixWidth){
			
			tileX = startX - localX;
			
			startY = tileHeight * stepsY;
			modelY = stepsY;
			while(startY <= endY && modelY < matrixHeight){
				
				tileY = startY - localY;
				
				byte state = matrix[modelX][modelY];
				if(state != EMPTY | listener.processEmpty){
					listener.onFoundTile(tileX, tileY, tileWidth, tileHeight, state);
				}
				
				startY = startY + tileHeight;
				modelY++;
			}
			
			startX = startX + tileWidth;
			modelX++;
		}
		
		
		
	}

	private int getPositiveX(int x) {
		if(x < 0) x = 0;
		return x;
	}
	
	private int getRecWidth(int x, int recWidth) {
		if(x >=0){
			return recWidth;
		}
		return recWidth + x;
	}
	
	private int getPositiveY(int y) {
		if(y < 0) y = 0;
		return y;
	}
	
	private int getRecHeight(int y, int recHeight) {
		if(y >=0){
			return recHeight;
		}
		return recHeight + y;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}
	
	

}
