package com.spaceage.app;

import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.PlatformFactory;

/**
 * Global
 */
public class G {
	
	public static PlatformFactory factory;
	
	public static Window initialWindow;
	
	//world const
	public static float slowdownConst = 0.5f; //no slowdown
	
	public static float gravityConst = 0.35f;
	
	public static float slowdownAccelerationX = 0.01f;
	
	public static float maxVelocity = 30;
	
	public static float maxAcceleraton = 30;
	
	public static boolean showVelocityVector = true;
	
	public static boolean showSpriteBounds = true;

	
	

}
