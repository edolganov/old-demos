package tatia.app;


import tatia.app.main.App;
import tatia.swing.util.laf.Laf;

public class Main {
	
	public static void main(String[] args) {
		Laf.setNimbusLaf();
		Laf.setupEnterActionForAllButtons();
		
		new App().init();
	}

}
