package com.spaceage.swing.platform;

import java.io.InputStream;

import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.PlatformFactory;

public class PlatformFactoryImpl extends PlatformFactory {

	@Override
	public Image createImage(InputStream is) {
		return new ImageImpl(is);
	}

}
