package com.spaceage.core.platform;

import java.io.InputStream;

public abstract class PlatformFactory {
	
	public Image createImage(String resourcePath){
		InputStream is = getClass().getResourceAsStream(resourcePath);
		return createImage(is);
	}
	
	public abstract Image createImage(InputStream is);

}
