package com.spaceage.app;

import com.spaceage.core.platform.PlatformFactory;
import com.spaceage.core.shape.Window;

/**
 * Global
 */
public class G {
	
	static PlatformFactory factory;
	
	static double slowdownConst = 0.1;
	
	static Window initialWindow;
	
	static int tilesResolution = 10;
	
	

	public static PlatformFactory factory() {
		return factory;
	}

	public static double slowdownConst() {
		return slowdownConst;
	}

	public static Window initialWindow() {
		return initialWindow;
	}

//	public static int tilesResolution() {
//		return tilesResolution;
//	}
	
	

}
