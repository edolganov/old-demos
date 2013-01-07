package com.spaceage.core.tiles;

import java.util.ArrayList;

public class FoundedTiles {
	
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
	
	
	public ArrayList<TileInfo> list;
	public int tileWidth;
	public int tileHeight;
	
	public FoundedTiles(ArrayList<TileInfo> list, int tileWidth, int tileHeight) {
		
		if(list == null) list = new ArrayList<FoundedTiles.TileInfo>();
		
		this.list = list;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}
	

	
	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	public TileInfo findMaxByY() {
		TileInfo out = null;
		for (int i = 0; i < list.size(); i++) {
			TileInfo tile = list.get(i);
			if(out == null || out.y > tile.y){
				out = tile;
			}
		}
		return out;
	}

	public TileInfo findMinByY() {
		TileInfo out = null;
		for (int i = 0; i < list.size(); i++) {
			TileInfo tile = list.get(i);
			if(out == null || out.y < tile.y){
				out = tile;
			}
		}
		return out;
	}

	public TileInfo findMaxByX() {
		TileInfo out = null;
		for (int i = 0; i < list.size(); i++) {
			TileInfo tile = list.get(i);
			if(out == null || out.x > tile.x){
				out = tile;
			}
		}
		return out;
	}

	public TileInfo findMinByX() {
		TileInfo out = null;
		for (int i = 0; i < list.size(); i++) {
			TileInfo tile = list.get(i);
			if(out == null || out.x < tile.x){
				out = tile;
			}
		}
		return out;
	}

}
