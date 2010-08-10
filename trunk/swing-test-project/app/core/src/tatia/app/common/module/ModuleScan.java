package tatia.app.common.module;

import java.awt.Component;
import java.awt.Container;
import java.util.LinkedList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ModuleScan {
	
	private static final Log log = LogFactory.getLog(ModuleScan.class);
	
	public ModuleScan() {
	}

	public void scanAndInit(Container root) {
		LinkedList<Container> queue = new LinkedList<Container>();
		queue.addLast(root);
		
		while(!queue.isEmpty()){
			//process candidat
			Container candidat = queue.removeFirst();
			if(candidat instanceof Module){
				//log.info("init module: "+candidat.getClass().getName());
				((Module)candidat).init();
			}
			
			//add children
			Component[] children = candidat.getComponents();
			if(children != null){
				for (Component component : children) {
					if(component instanceof Container){
						queue.addLast((Container)component);
					}
				}
			}
		}
	}

}
