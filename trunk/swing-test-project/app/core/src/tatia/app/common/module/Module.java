package tatia.app.common.module;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tatia.app.common.controller.Controller;
import tatia.app.common.controller.ControllerScan;


public abstract class Module<T extends Component> extends JPanel {
	
	protected T ui;
	protected final Log log;
	
	
	
	public Module() {
		super();
		setLayout(new BorderLayout());
		this.ui = createUI();
		if(ui == null) throw new IllegalStateException("UI component is null");
		add(ui,BorderLayout.CENTER);
		
		log = LogFactory.getLog(this.getClass());
	}
	

	
	
	public void init() {
		new ControllerScan().scanAndInit(this.getClass().getPackage().getName(), ui);
	}
	
	protected abstract T createUI();
	
	
	public static <T extends Controller<?>> T get(Class<T> clazz){
		return (T)Controller.get(clazz);
	}
	
	

}
