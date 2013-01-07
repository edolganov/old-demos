package com.spaceage.swing.platform;

import com.spaceage.core.platform.ActionCodes;


public class ActionCodesImpl implements ActionCodes {
	
	//<- 37, -> 39, up - 38, down - 40

	@Override
	public int goLeft() {
		return 37;
	}

	@Override
	public int goRight() {
		return 39;
	}

	@Override
	public int jump() {
		return 32;
	}

}
