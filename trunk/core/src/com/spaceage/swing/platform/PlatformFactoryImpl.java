package com.spaceage.swing.platform;

import java.io.InputStream;

import com.spaceage.core.platform.ActionCodes;
import com.spaceage.core.platform.Image;
import com.spaceage.core.platform.PlatformFactory;

public class PlatformFactoryImpl extends PlatformFactory {
	
	ActionCodesImpl actionCodes = new ActionCodesImpl();

	@Override
	public Image createImage(InputStream is) {
		return new ImageImpl(is);
	}

	@Override
	public Image createEmptyImage(int width, int height) {
		return new ImageImpl(width, height);
	}

	@Override
	public ActionCodes actionCodes() {
		return actionCodes;
	}

}
