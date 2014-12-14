package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class PrettifyExampleResources implements Controller {

    public static final String DEMO_URL = PrettifyExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource prettify = PrettifyExampleClientBundle.INSTANCE.prettify();
    public static final HtmlResource demo = PrettifyExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = PrettifyExampleClientBundle.INSTANCE.config();
    public static final TextResource module = PrettifyExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = PrettifyExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = PrettifyExampleClientBundle.INSTANCE.view();
    
    @Override
    public void onControllerLoad() {
    }
}

interface PrettifyExampleClientBundle extends ClientBundle {

    static final PrettifyExampleClientBundle INSTANCE = GWT.create(PrettifyExampleClientBundle.class);

    @Source("PrettifyExampleDocumentation.html")
    HtmlResource prettify();

    @Source("PrettifyExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/PrettifyExample.gwt.xml")
    TextResource config();
    
    @Source("PrettifyExample.java")
    TextResource module();
    
    @Source("PrettifyExampleController.java")
    TextResource controller();
    
    @Source("PrettifyExample.html")
    TextResource view();
}
