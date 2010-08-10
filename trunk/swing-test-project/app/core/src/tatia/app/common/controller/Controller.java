package tatia.app.common.controller;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tatia.swing.core.controller.GenericController;

public abstract class Controller<T> extends GenericController<T>{
	
	public static HashMap<String, Controller<?>> controllers = new HashMap<String, Controller<?>>();
	
	protected final Log log;
	
	
	public Controller() {
		controllers.put(this.getClass().getName(), this);
		log = LogFactory.getLog(this.getClass());
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Controller<?>> T get(Class<T> clazz){
		return (T)controllers.get(clazz.getName());
	}

}
