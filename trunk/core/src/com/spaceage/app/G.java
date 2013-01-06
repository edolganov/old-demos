package com.spaceage.app;

import com.spaceage.core.basic.Window;
import com.spaceage.core.platform.PlatformFactory;

/**
 * Global
 */
public class G {
	
	static PlatformFactory factory;
	
	static Window initialWindow;
	
	//world const
	static float slowdownConst = 1; //no slowdown
	
	static float gravityConst = 0.35f;
	
	static float slowdownAccelerationX = 0.01f;
	
	static float maxVelocity = 30;
	
	static float maxAcceleraton = 30;
	
	static boolean showVelocityVector = true;
	
	

	public static PlatformFactory factory() {
		return factory;
	}

	public static float slowdownConst() {
		return slowdownConst;
	}

	public static Window initialWindow() {
		return initialWindow;
	}
	
	public static float gravityConst(){
		return gravityConst;
	}
	
	public static float slowdownAccelerationX(){
		return slowdownAccelerationX;
	}
	
	public static float maxVelocity(){
		return maxVelocity;
	}
	
	public static float maxAcceleraton(){
		return maxAcceleraton;
	}
	
	public static boolean showVelocityVector() {
		return showVelocityVector;
	}
	
	

}
