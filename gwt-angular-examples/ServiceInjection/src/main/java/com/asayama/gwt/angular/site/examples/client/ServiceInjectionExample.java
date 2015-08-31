package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;

public class ServiceInjectionExample extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        service(MyService.class);
        controller(ServiceInjectionExampleController.class);
    }
}
