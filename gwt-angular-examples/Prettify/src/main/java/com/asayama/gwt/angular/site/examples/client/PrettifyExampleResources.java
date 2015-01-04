package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class PrettifyExampleResources extends AbstractController {

    private static final PrettifyExampleClientBundle RESOURCES = GWT.create(PrettifyExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource prettify = RESOURCES.prettify();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
}

interface PrettifyExampleClientBundle extends ClientBundle {

    @Source("PrettifyExampleDocumentation.html")
    HtmlResource prettify();

    @Source("PrettifyExample.html")
    HtmlResource demo();

    @Source("com/asayama/gwt/angular/site/examples/PrettifyExample.gwt.xml")
    TextResource config();
    
    @Source("PrettifyExample.java")
    TextResource module();
    
    @Source("PrettifyExampleController.java")
    TextResource controller();
    
    @Source("PrettifyExample.html")
    TextResource view();
}
