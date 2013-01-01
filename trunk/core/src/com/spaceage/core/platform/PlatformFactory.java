package com.spaceage.core.platform;

import java.io.InputStream;

public interface PlatformFactory {
	
	
	Image createImage(InputStream is);

}
