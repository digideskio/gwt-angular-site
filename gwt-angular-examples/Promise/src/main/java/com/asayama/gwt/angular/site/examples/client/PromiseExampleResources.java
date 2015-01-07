package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class PromiseExampleResources extends AbstractController {

    private static final PromiseExampleClientBundle RESOURCES = GWT.create(PromiseExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource promise = RESOURCES.promise();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
    public static final TextResource service = RESOURCES.service();
}

interface PromiseExampleClientBundle extends ClientBundle {

    @Source("PromiseExampleDocumentation.html")
    HtmlResource promise();

    @Source("PromiseExample.html")
    HtmlResource demo();
    
    @Source("com/asayama/gwt/angular/site/examples/PromiseExample.gwt.xml")
    TextResource config();
    
    @Source("PromiseExample.java")
    TextResource module();
    
    @Source("PromiseExampleController.java")
    TextResource controller();

    @Source("PromiseExample.html")
    TextResource view();
    
    @Source("service/GreetingService.java")
    TextResource service();
}