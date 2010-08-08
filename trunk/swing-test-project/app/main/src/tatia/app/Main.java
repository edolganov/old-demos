package tatia.app;

import javax.swing.JTree;

import tatia.swing.core.test.TestFrame;
import tatia.swing.util.laf.Laf;

public class Main {
	
	public static void main(String[] args) {
		Laf.setNimbusLaf();
		//test app
		TestFrame f = new TestFrame("привет мир!");
		f.add(new JTree());
		f.setVisible(true);
	}

}
