package com.spaceage.util;

public class MathUtil {
	
	public static int getMinVal(int a, int b) {
		return Math.min(a, b);
	}
	
	public static int getLength(int a, int b) {
		if(a >= 0){
			if(b >= 0){
				return Math.abs(a-b);
			}
			else {
				return a-b;
			}
		}else{
			if(b < 0){
				return Math.abs(a-b);
			}
			else {
				return b-a;
			}
		}
	}

}
