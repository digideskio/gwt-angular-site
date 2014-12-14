package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class PromiseExampleResources implements Controller {

    public static final String DEMO_URL = PromiseExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource promise = PromiseExampleClientBundle.INSTANCE.promise();
    public static final HtmlResource demo = PromiseExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = PromiseExampleClientBundle.INSTANCE.config();
    public static final TextResource module = PromiseExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = PromiseExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = PromiseExampleClientBundle.INSTANCE.view();
    public static final TextResource service = PromiseExampleClientBundle.INSTANCE.service();
    
    @Override
    public void onControllerLoad() {
    }
}

interface PromiseExampleClientBundle extends ClientBundle {

    static final PromiseExampleClientBundle INSTANCE = GWT.create(PromiseExampleClientBundle.class);

    @Source("PromiseExampleDocumentation.html")
    HtmlResource promise();

    @Source("PromiseExample.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/PromiseExample.gwt.xml")
    TextResource config();
    
    @Source("PromiseExample.java")
    TextResource module();
    
    @Source("PromiseExampleController.java")
    TextResource controller();

    @Source("PromiseExample.html")
    TextResource view();
    
    // Other Resources
    
    @Source("service/GreetingService.java")
    TextResource service();
}