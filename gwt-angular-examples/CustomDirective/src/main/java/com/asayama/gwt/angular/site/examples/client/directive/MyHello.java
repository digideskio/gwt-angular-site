package com.asayama.gwt.angular.site.examples.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class MyHello extends AbstractDirective {

    @Override
    public TextResource getTemplate() {
        MyHelloResource RESOURCES = GWT.create(MyHelloResource.class);
        return RESOURCES.template();
    }

    /**
     * Creates isolateScope and registers the following attribute definition.
     * <ul>
     * <li>{@code String} my-hello</li>
     * </ul>
     */
    @Override
    public NGScope scope() {
        NGScope scope = NGScope.create();
        scope.put(getName(), "="); //register main attribute value
        return scope;
    }
}

interface MyHelloResource extends ClientBundle {
    
    @Source("MyHello.html")
    TextResource template();
}
