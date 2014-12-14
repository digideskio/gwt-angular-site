package com.asayama.gwt.angular.site.pages.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;


public class Pages extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
    }
}
