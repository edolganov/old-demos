package com.spaceage.core.tiles;

public abstract class FindTilesListener {
	
	public boolean processEmpty = false;
	
	public FindTilesListener() {}
	
	public FindTilesListener(boolean processEmpty) {
		this.processEmpty = processEmpty;
	}

	public abstract void onFoundTile(int x, int y, int width, int height, byte state);

}
