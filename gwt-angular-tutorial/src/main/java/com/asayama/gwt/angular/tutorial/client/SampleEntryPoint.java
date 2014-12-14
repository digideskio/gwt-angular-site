package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;

/**
 * GWT Module's EntryPoint implementation. It binds the Angular Modules to this
 * this application's view component, which is found under "public" directory
 * of Java package <code>com.asayama.gwt.angular.tutorial</code>.
 * 
 * @author kyoken74
 */
public class SampleEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Angular.bootstrap();
    }
}
