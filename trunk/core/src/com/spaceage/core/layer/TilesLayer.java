package com.spaceage.core.layer;

import com.spaceage.app.G;
import com.spaceage.core.painter.TilesPainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.shape.Window;
import com.spaceage.core.tiles.TilesModel;
import com.spaceage.util.ColorUtil;

public class TilesLayer extends Layer {
	
	TilesModel tiles;
	TilesPainter painter;
	
	public TilesLayer(int offsetX, int offsetY, TilesPainter painter, int width, int height) {

		tiles = new TilesModel(offsetX, offsetY, width, height);
		painter.setModel(tiles);
		this.painter = painter;
	}
	
	public TilesLayer(int offsetX, int offsetY, TilesPainter painter, String modelImgPath) {
		
		Image modelImg = G.factory().createImage(modelImgPath);
		int width = modelImg.getWidth();
		int height = modelImg.getHeight();
		
		tiles = new TilesModel(offsetX, offsetY, width, height);
		for(int x=0; x < width; ++x){
			for(int y=0; y<height; y++){
				
				int color = modelImg.getRGBA(x, y);
				if(color == ColorUtil.WHITE_COLOR){
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