package tatia.app.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import tatia.swing.core.controller.ControllerInfo;


public class ControllerScan {
	
	private static final Log log = LogFactory.getLog(ControllerScan.class);
	
	private static class CE {
		Class<?> clazz;
		Object target;
		public CE(Class<?> clazz, Object target) {
			super();
			this.clazz = clazz;
			this.target = target;
		}
	}
		
	private HashMap<String, ArrayList<CE>> queue = new HashMap<String, ArrayList<CE>>();
	private HashSet<Controller<?>> afterAllInitSet = new HashSet<Controller<?>>();
	
	
	
	public ControllerScan() {
	}

	public void scanAndInit(String packagePreffix, Object initOb){
		if(packagePreffix == null) throw new IllegalArgumentException("packagePreffix is null");
		if(initOb == null) throw new IllegalArgumentException("initOb is null");
		Class<?> initObClazz = initOb.getClass();
		
		Reflections reflections = new Reflections(new ConfigurationBuilder()
        .setUrls(ClasspathHelper.getUrlsForPackagePrefix(packagePreffix))
        .setScanners(new TypeAnnotationsScanner())
		.filterInputsBy(new FilterBuilder.Include(FilterBuilder.prefix(packagePreffix))));
		
//		Reflections reflections =  new Reflections(packagePreffix);
		
		Set<Class<?>> all = reflections.getTypesAnnotatedWith(ControllerInfo.class);
		//System.out.println("ControllerScan.scanAndInit: "+all.size());
		//System.out.println(System.getProperty("java.class.path"));
		for (Class<?> controller : all) {
			ControllerInfo ci = controller.getAnnotation(ControllerInfo.class);
			try {
				Class<?> targetClass = ci.target();
				if(targetClass == null) throw new IllegalStateException("null target of controller:"+controller);
				
				if(!targetClass.equals(initObClazz)){
					continue;
				}
				
				Class<?> dependenceClass =  ci.dependence();
				String dependenceClassName = dependenceClass.getName();
				if(dependenceClass.equals(Object.class)){
					initController(controller, initOb);
					String name = controller.getName();
					if(queue.containsKey(name)){
						for(CE ce : queue.get(name)){
							initController(ce.clazz, ce.target);
						}
						queue.remove(name);
					}
				}
				else if(!Controller.class.isAssignableFrom(dependenceClass)){
					throw new IllegalStateException("unknow controller's dependence class:"+dependenceClass);
				}
				else {
					if(Controller.controllers.containsKey(dependenceClassName)){
						initController(controller, initOb);
					}
					else {
						ArrayList<CE> list = queue.get(dependenceClassName);
						if(list == null){
							list = new ArrayList<CE>();
							queue.put(dependenceClassName, list);
						}
						list.add(new CE(controller, initOb));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(queue.size() > 0){
			LogFactory.getLog(getClass()).warn("uninited componets "+queue);
		}
		
	}
	
	private void initController(Class<?> clazz, Object target) throws InstantiationException, IllegalAccessException {
		Controller<?> c = (Controller<?>) clazz.newInstance();
		// System.out.println("init c:" + c);
		//log.info("init controller: "+c.getClass().getName());
		c.initUnsaveObject(target);
		afterAllInitSet.add(c);
	}

}
