package com.spaceage.core.painter;

import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.tiles.FindTilesListener;
import com.spaceage.core.tiles.TilesModel;

public abstract class TilesPainter {
	
	TilesModel model;

	public void setModel(TilesModel model) {
		this.model = model;
	}

	public void drawTiles(final Window w, final GraphicsManager manager, final Object platformGraphics) {
		if(model == null){
			return;
		}
		
		model.findTiles(w, new FindTilesListener() {

			@Override
			public void onFoundTile(int x, int y, int width, int height, byte state) {
				
				Image img = getTileImg(x, y, width, height, state);
				if(img == null){
					return;
				}
				
				int winX = x - w.x;
				int winY = y - w.y;
				
				manager.draw(img, winX, winY, platformGraphics);
				
			}
		});
		
	}
	
	protected abstract Image getTileImg(int x, int y, int width, int height, byte state);
	

}
