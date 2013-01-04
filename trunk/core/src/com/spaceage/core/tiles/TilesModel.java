package com.spaceage.core.tiles;

import com.spaceage.core.shape.Rectangle;

public class TilesModel {
	
	public static final int EMPTY = 0; 
	public static final int GROUND = 1;
	
	int offsetX;
	int offsetY;
	byte[][] matrix;
	int width;
	int height;
	
	public TilesModel(int offsetX, int offsetY, int width, int height) {
		matrix = new byte[width][height];
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
	}

	public void setGround(int modelX, int modelY) {
		matrix[modelX][modelY] = GROUND;
	}
	
	
	public void findTiles(Rectangle rec, FindTilesListener listener){
		
		
	}
	
	public byte getState(int winX, int winY){
		int x = winX - offsetX;
		int y = winY - offsetY;
		
		
		if(x < 0 || x >= width || y < 0 || y >= height){
			return EMPTY;
		}
		return matrix[x][y];
	}

}
