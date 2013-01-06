package com.spaceage.core.tiles;

import java.util.ArrayList;

public class FoundedTiles {
	
	public ArrayList<TileInfo> list;
	public int tileWidth;
	public int tileHeight;
	
	public FoundedTiles(ArrayList<TileInfo> list, int tileWidth, int tileHeight) {
		super();
		this.list = list;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}
	
	public static class TileInfo {
		
		public int x;
		public int y;
		public byte state;
		
		public TileInfo(int x, int y, byte state) {
			super();
			this.x = x;
			this.y = y;
			this.state = state;
		}
		
	}

}
