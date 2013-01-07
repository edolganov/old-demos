package com.spaceage.core;

import com.spaceage.core.basic.Window;
import com.spaceage.core.input.KeyManager;
import com.spaceage.core.platform.ActionCodes;
import com.spaceage.core.platform.PlatformFactory;

/**
 * Global
 */
public class G {
	
	//platform
	public static PlatformFactory factory;
	
	public static ActionCodes actionCodes;
	
	public static Window initialWindow;
	
	public static final KeyManager keyManager = new KeyManager();
	
	//world
	public static float slowdownConst = 1f; //1 = no slowdown
	
	public static float gravityConst = 0.35f;
	
	public static float slowdownAccelerationX = 0.01f;
	
	public static float maxVelocity = 30;
	
	public static float maxAcceleration = 30;
	
	public static boolean showVelocityVector = true;
	
	public static boolean showSpriteBounds = true;
	

	
	

}
