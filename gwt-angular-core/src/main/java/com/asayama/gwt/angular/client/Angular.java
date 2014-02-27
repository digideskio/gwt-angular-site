package com.asayama.gwt.angular.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;
import com.google.gwt.core.client.GWT;

/**
 * Provides GWT Java representation of AngularJS's angular object.
 * 
 * @author kyoken74
 */
public class Angular {
	
    static final AbstractModule[] MODULE_ARRAY = new AbstractModule[0];
    static List<AbstractModule> modules = new ArrayList<AbstractModule>();
    static Map<String, AbstractModule> index = new HashMap<String, AbstractModule>();
    
    public static AbstractModule[] modules() {
        return modules.toArray(MODULE_ARRAY);
    }
    
	public static <T extends AbstractModule> T module(T module, String... requires) {
		Closure closure = new Closure() {
			@Override
			public void closure(Object... args) {
				//noop
			}
		};
		return module(module, closure, requires);
	}
	
    public static <T extends AbstractModule> T module(T module, Closure closure, String... requires) {
        return module(module.getClass().getName(), module, closure, requires);
    }
    
	public static <T extends AbstractModule> T module(String name, T module, Closure closure, String... requires) {
	    modules.add(module);
	    index.put(name, module);
		JSArray<String> jsrequires = JSArray.create(requires);
		JSClosure jsclosure = JSClosure.create(closure);
		module.jso = _module(name, jsrequires, jsclosure);
		return module;
	}
	
    public static void bootstrap() {
        bootstrap(modules());
    }
    
	public static void bootstrap(AbstractModule... modules) {
		String m = "";
        StringBuilder sb = new StringBuilder();
		JSArray<String> jsarray = JSArray.create();
		for (int i = 0; i < modules.length; i++) {
			jsarray.add(modules[i].getClass().getName());
            sb.append("\n").append(modules[i].getClass().getName());
		}
		try {
		    GWT.log(m = "bootstrapping " + jsarray.size() + " modules" + sb.toString());
			_bootstrap(jsarray);
		} catch (Exception e) {
			GWT.log("Exception while " + m, e);
		}
	}

	private static native JSModule _module(String name, JSArray<String> requires, JSFunction<?> ctor) /*-{
		return $wnd.angular.module(name, requires, ctor);
	}-*/;
	
	private static native void _bootstrap(JSArray<String> modules) /*-{
		$wnd.angular.bootstrap($doc, modules);
	}-*/;

}
