package com.spaceage.core.input;

import java.util.HashMap;

public class KeyManager {
	
	private HashMap<Integer, KeyInfo> keys = new HashMap<Integer, KeyInfo>();
	
	
	
	public void onAction(KeyAction action){
		
		int code = action.code;
		KeyState state = action.state;
		
		KeyInfo info = keys.get(code);
		if(info == null){
			info = new KeyInfo(null);
			keys.put(code, info);
		}
		
		if(info.state == state){
			return;
		}
		
		info.state = state;
		
	}
	
	public KeyState getState(int code){
		KeyInfo info = keys.get(code);
		return info == null? null : info.state;
	}

}
