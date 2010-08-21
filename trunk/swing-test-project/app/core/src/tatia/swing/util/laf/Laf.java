package tatia.swing.util.laf;

import javax.swing.InputMap;
import javax.swing.KeyStroke;
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
	
    public static void setupEnterActionForAllButtons() {
        InputMap im = (InputMap) UIManager.getDefaults().get("Button.focusInputMap");
        Object pressedAction = im.get(KeyStroke.getKeyStroke("pressed SPACE"));
        Object releasedAction = im.get(KeyStroke.getKeyStroke("released SPACE"));

        im.put(KeyStroke.getKeyStroke("pressed ENTER"), pressedAction);
        im.put(KeyStroke.getKeyStroke("released ENTER"), releasedAction);
    }

}
