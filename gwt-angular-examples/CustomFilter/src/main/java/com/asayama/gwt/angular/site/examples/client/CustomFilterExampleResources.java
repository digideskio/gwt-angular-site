package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class CustomFilterExampleResources extends AbstractController {

    private static final CustomFilterExampleClientBundle RESOURCES = GWT.create(CustomFilterExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource customFilter = RESOURCES.customFilter();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
    public static final TextResource filter = RESOURCES.filter();
}

interface CustomFilterExampleClientBundle extends ClientBundle {

    @Source("CustomFilterExampleDocumentation.html")
    HtmlResource customFilter();

    @Source("CustomFilterExample.html")
    HtmlResource demo();

    @Source("com/asayama/gwt/angular/site/examples/CustomFilterExample.gwt.xml")
    TextResource config();

    @Source("CustomFilterExample.java")
    TextResource module();
    
    @Source("CustomFilterExampleController.java")
    TextResource controller();
    
    @Source("CustomFilterExample.html")
    TextResource view();

    @Source("filter/Reverse.java")
    TextResource filter();
}

