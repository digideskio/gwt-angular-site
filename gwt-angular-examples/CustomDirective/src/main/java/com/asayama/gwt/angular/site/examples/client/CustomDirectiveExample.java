package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.examples.client.directive.MyHello;
import com.google.gwt.core.client.EntryPoint;

public class CustomDirectiveExample extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        directive(MyHello.class);
        controller(CustomDirectiveExampleController.class);
    }
}

