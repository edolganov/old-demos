package com.spaceage.app.painter;

import com.spaceage.app.G;
import com.spaceage.core.painter.TilesPainter;
import com.spaceage.core.platform.Image;
import com.spaceage.core.tiles.TilesModel;

public class Level1Painter extends TilesPainter {
	
	Image graundBlock = G.factory.createImage("/content/tiles/ground-01.png");

	@Override
	protected Image getTileImg(int x, int y, int width, int height, byte state) {
		if(state == TilesModel.GROUND){
			return graundBlock;
		}
		return null;
	}

}
