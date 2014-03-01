package com.asayama.gwt.angular.sanitize.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class NGSanitize extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "";
        try {
            GWT.log(m = "initializing " + getClass().getName());
            Angular.module(this, "ngSanitize");
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
