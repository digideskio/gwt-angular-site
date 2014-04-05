package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.util.client.Strings;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;


public abstract class AbstractModule implements Module {

    JSModule jso;
    
    @Override
    public void bind(JSModule jso) {
        this.jso = jso;
    }

    @Override
    public String getName() {
        return jso.getName();
    }

    @Override
    public Module value(String name, Object value) {
        jso.value(name, value);
        return this;
    }

    @Override
    public Module constant(String name, Object value) {
        jso.constant(name, value);
        return this;
    }
    
    @Override
    public <F extends Filter> Module filter(Class<F> klass) {
        F filter = FilterCreator.INSTANCE.create(klass);
        return filter(filter);
    }
    
    protected Module filter(Filter filter) {
        String className = Strings.simpleClassName(filter);
        return filter(Strings.decapitalize(className), filter);
    }
    
    protected Module filter(String name, Filter filter) {
        String[] dependencies = FilterDependenciesFactory.INSTANCE.create(filter);
        JSClosure binder = FilterBinderFactory.INSTANCE.create(filter);
        jso.filter(name, JSArray.create(dependencies),
                JSFunction.create(new FilterWrapper(binder, filter)));
        return this;
    }

    @Override
    public <D extends Directive> Module directive(Class<D> klass) {
        D directive = DirectiveCreator.INSTANCE.create(klass);
        return directive(directive);
    }
    
    protected Module directive(Directive directive) {
        String className = Strings.simpleClassName(directive);
        return directive(Strings.decapitalize(className), directive);
    }
    
    protected Module directive(String name, final Directive directive) {
        if (directive == null) {
            return null;
        }
        directive.setName(name);
        String[] dependencies = DirectiveDependenciesFactory.INSTANCE.create(directive);
        JSClosure binder = DirectiveBinderFactory.INSTANCE.create(directive);
        jso.directive(name, JSArray.create(dependencies),
                JSFunction.create(new DirectiveWrapper(binder, directive)));
        return this;
    }
    
    @Override
    public <P extends Provider> Module config(final Class<P> klass, final Configurator<P> configurator) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
        final P provider = ProviderCreator.INSTANCE.create(klass);
        final JSClosure binder = ProviderBinderFactory.INSTANCE.create(provider);
        Function<P> initializer = new Function<P>() {

            @Override
            public P call(Object... args) {
                binder.apply(args);
                configurator.configure(provider);
                return provider;
            }
        };
        String[] dependencies = ProviderDependenciesFactory.INSTANCE.create(provider);
        jso.config(JSArray.create(dependencies), JSFunction.create(initializer));
        return this;
    }

    @Override
    public <S extends Service> Module factory(Class<S> klass) {
        S service = ServiceCreator.INSTANCE.create(klass);
        return factory(klass.getName(), service);
    }
    
    protected Module factory(String name, final Service service) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
        final JSClosure binder = ServiceBinderFactory.INSTANCE.create(service);
        Function<Service> initializer = new Function<Service>() {

            @Override
            public Service call(Object... args) {
                binder.apply(args);
                return service;
            }
        };
        String[] dependencies = ServiceDependenciesFactory.INSTANCE.create(service);
        jso.factory(name, JSArray.create(dependencies), JSFunction.create(initializer));
        return this;
    }
    
    @Override
    public <C extends Controller> Module controller(Class<C> klass) {
        C controller = ControllerCreator.INSTANCE.create(klass);
        return controller(klass.getName(), controller);
    }

    protected Module controller(final String name, final Controller controller) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
        if (controller == null) {
            String message = "Unable to create " + name;
            GWT.log(message, new IllegalStateException(message));
            return this;
        }
        final JSClosure scopeBinder = ControllerScopeBinderFactory.INSTANCE.create(controller);
        if (scopeBinder == null) {
            String message = "Unable to create binder for " + name;
            GWT.log(message, new IllegalStateException(message));
            return this;
        }
        final JSClosure binder = ControllerBinderFactory.INSTANCE.create(controller);
        if (binder == null) {
            String message = "Unable to create injector for " + name;
            GWT.log(message, new IllegalStateException(message));
            return this;
        }
        Closure initializer = new Closure() {

            @Override
            public void exec(Object... args) {
                String m = "";
                try {
                    m = "shifing args";
                    Object[] shiftedArgs = new Object[args.length - 1];
                    for (int i = 0; i < shiftedArgs.length; i++) {
                        shiftedArgs[i] = args[i + 1];
                    }
                    m = "binding args";
                    scopeBinder.apply(args);
                    m = "injecting shiftedArgs";
                    binder.apply(shiftedArgs);
                    GWT.log(m = name + ".onControllerLoad()");
                    controller.onControllerLoad();
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
            }
        };
        String [] dependencies;
        {
            String[] d = ControllerDependenciesFactory.INSTANCE.create(controller);
            int len = d == null ? 0 : d.length;
            dependencies = new String[len + 1];
            dependencies[0] = "$scope";
            for (int i = 0; i < len; i++) {
                dependencies[i + 1] = d[i];
            }
        }
        jso.controller(name, JSArray.create(dependencies), JSClosure.create(initializer));
        return this;
    }
}

class JSModule extends JSObject {

    protected JSModule() {
    }

    final String getName() {
        return $string("name");
    }

    final native JSArray<String> requires() /*-{
		return this.requires;
    }-*/;
    
    final native void value(String name, Object value) /*-{
        this.value(name, value);
    }-*/;
    
    final native void constant(String name, Object value) /*-{
        this.constant(name, value);
    }-*/;
    
    final native void filter(String name, JSArray<String> dependencies, JSFunction<JSFilter> filter) /*-{
        dependencies.push(filter);
        this.filter(name, dependencies);
    }-*/;

    final native void directive(String name, JSArray<String> dependencies, JSFunction<JSDirective> directive) /*-{
        dependencies.push(directive);
        this.directive(name, dependencies);
    }-*/;

    final native void config(JSArray<String> dependencies, JavaScriptObject constructor) /*-{
        dependencies.push(constructor);
        this.config(dependencies);
    }-*/;
    
    final native <S extends Service> void factory(String name, JSArray<String> dependencies, JSFunction<S> constructor) /*-{
        dependencies.push(constructor);
        this.factory(name, dependencies);
    }-*/;
    
    final native void controller(String name, JSArray<String> dependencies, JSClosure constructor) /*-{
        dependencies.push(constructor);
        this.controller(name, dependencies);
    }-*/;
}
