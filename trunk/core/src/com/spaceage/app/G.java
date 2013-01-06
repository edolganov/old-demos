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
	static double slowdownConst = 1; //no slowdown
	
	static double gravityConst = 0.35;
	
	static double slowdownAccelerationX = 0.01;
	
	static double maxVelocity = 30;
	
	static double maxAcceleraton = 30;
	
	static boolean showVelocityVector = true;
	
	

	public static PlatformFactory factory() {
		return factory;
	}

	public static double slowdownConst() {
		return slowdownConst;
	}

	public static Window initialWindow() {
		return initialWindow;
	}
	
	public static double gravityConst(){
		return gravityConst;
	}
	
	public static double slowdownAccelerationX(){
		return slowdownAccelerationX;
	}
	
	public static double maxVelocity(){
		return maxVelocity;
	}
	
	public static double maxAcceleraton(){
		return maxAcceleraton;
	}
	
	public static boolean showVelocityVector() {
		return showVelocityVector;
	}
	
	

}
