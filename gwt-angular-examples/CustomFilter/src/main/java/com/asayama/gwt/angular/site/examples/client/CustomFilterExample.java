package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.examples.client.filter.Reverse;
import com.google.gwt.core.client.EntryPoint;

public class CustomFilterExample extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        filter(Reverse.class);
        controller(CustomFilterExampleController.class);
    }
}
