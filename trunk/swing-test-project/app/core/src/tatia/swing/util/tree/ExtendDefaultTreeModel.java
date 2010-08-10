package tatia.swing.util.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class ExtendDefaultTreeModel extends DefaultTreeModel {

	public ExtendDefaultTreeModel(DefaultMutableTreeNode root, boolean asksAllowsChildren) {
		super(root, asksAllowsChildren);
	}

	public ExtendDefaultTreeModel(TreeNode root) {
		super(root);
	}
	
	@Override
	public DefaultMutableTreeNode getRoot() {
		return (DefaultMutableTreeNode)super.getRoot();
	}
	
	public static ExtendDefaultTreeModel createTreeModel(Object rootObject){
		DefaultMutableTreeNode treeModelRoot = new DefaultMutableTreeNode(rootObject);
		return new ExtendDefaultTreeModel(treeModelRoot, false);
	}

}
