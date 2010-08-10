package tatia.app.main;

import tatia.app.common.module.ModuleScan;
import tatia.app.main.ui.MainForm;

public class App {
	
	MainForm ui;
	
	public void init(){
		ui = new MainForm();
		
		//инитим модули вложенные в ui
		new ModuleScan().scanAndInit(ui);
		
		ui.setVisible(true);
		
		ui.testModule1.addTreeElement("element from App");
	}

}
