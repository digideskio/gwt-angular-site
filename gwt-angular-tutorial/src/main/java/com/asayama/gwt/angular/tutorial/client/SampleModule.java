package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.google.gwt.core.client.EntryPoint;


public class SampleModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        controller(SampleController.class);
        config(RouteProvider.class, new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider routeProvider) {
                routeProvider
                    .when(SampleResources.INSTANCE.sample(), SampleController.class)
                    .otherwise(SampleResources.INSTANCE.sample());
            }
        });
    }
}
