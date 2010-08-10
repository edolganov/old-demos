package tatia.app.modules.testmodule;

import tatia.app.common.module.Module;
import tatia.app.modules.testmodule.tree.TreeController;
import tatia.app.modules.testmodule.ui.TestUI;

public class TestModule extends Module<TestUI>{
	
	public TestModule() {
		super();
	}

	@Override
	protected TestUI createUI() {
		return new TestUI();
	}
	
	//модуль имеет публичные методы
	public void addTreeElement(String data){
		//реализация метода делегируется контроллерам модуля
		get(TreeController.class).addTreeElement(data);
	}
	
	public void removeTreeElement(String data){
		get(TreeController.class).removeTreeElement(data);
	}

}
