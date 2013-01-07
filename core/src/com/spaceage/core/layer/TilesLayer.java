package com.spaceage.core.layer;

import com.spaceage.core.G;
import com.spaceage.core.basic.Window;
import com.spaceage.core.painter.TilesPainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.tiles.TilesModel;
import com.spaceage.util.ColorUtil;

public class TilesLayer extends Layer {
	
	TilesPainter painter;
	
	public TilesLayer(int offsetX, int offsetY, TilesPainter painter, int width, int height, int tileWidth, int tileHeight) {

		this.tiles = new TilesModel(offsetX, offsetY, width, height, tileWidth, tileHeight);
		painter.setModel(tiles);
		this.painter = painter;
	}
	
	public TilesLayer(int offsetX, int offsetY, TilesPainter painter, String modelImgPath, int tileWidth, int tileHeight) {
		
		Image modelImg = G.factory.createImage(modelImgPath);
		int width = modelImg.getWidth();
		int height = modelImg.getHeight();
		
		this.tiles = new TilesModel(offsetX, offsetY, width, height, tileWidth, tileHeight);
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				int color = modelImg.getRGBA(x, y);
				if(color == ColorUtil.WHITE){
					tiles.setGround(x, y);
				}
			}
		}
		
		painter.setModel(tiles);
		this.painter = painter;
	}
	
	

	@Override
	protected void drawBackgroud(Window w, GraphicsManager manager, Object platformGraphics) {
		painter.drawTiles(w, manager, platformGraphics);
	}

}
