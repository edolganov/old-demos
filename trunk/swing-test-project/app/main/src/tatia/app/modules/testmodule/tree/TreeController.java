package tatia.app.modules.testmodule.tree;

import javax.swing.JTree;

import tatia.app.common.controller.Controller;
import tatia.app.modules.testmodule.ui.TestUI;
import tatia.swing.core.controller.ControllerInfo;
import tatia.swing.util.tree.ExtendDefaultTreeModel;
import tatia.swing.util.tree.TreeUtil;

@ControllerInfo(target=TestUI.class)
public class TreeController extends Controller<TestUI>{
	
	JTree tree;

	@Override
	public void init(TestUI ui) {
		tree = ui.jTree1;
		tree.setModel(ExtendDefaultTreeModel.createTreeModel("root"));
		TreeUtil.addChild(tree, null, "child 1");
		TreeUtil.addChild(tree, null, "child 2");
		TreeUtil.addChild(tree, null, "child 3");
	}

	public void addTreeElement(String data) {
		TreeUtil.addChild(tree, null, data);		
	}

	public void removeTreeElement(String data) {
		//STUB
	}
	
	

}
