package ru.test.swing.util.laf;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Laf {
	
	public static void setNimbusLaf(){
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    		//System.out.println(info);
            if ("Nimbus".equals(info.getName())) {
            	try{
            		//it's com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
            		//from http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/color.html
            		UIManager.setLookAndFeel(info.getClassName());
//            		UIManager.put("nimbusBase", new Color(...));
//            		UIManager.put("nimbusBlueGrey", new Color(...));
//            		UIManager.put("control", new Color(...));
//            		System.out.println(UIManager.get("nimbusBase"));
//            		System.out.println(UIManager.get("nimbusBlueGrey"));
//            		System.out.println(UIManager.get("control"));
            	}	catch (Exception e) {
					e.printStackTrace();
				}
                break;
            }
        }
	}

}
