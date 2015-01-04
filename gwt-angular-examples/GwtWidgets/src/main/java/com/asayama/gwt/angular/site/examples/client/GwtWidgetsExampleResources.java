package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class GwtWidgetsExampleResources extends AbstractController {

    private static final GwtWidgetsExampleClientBundle RESOURCES = GWT.create(GwtWidgetsExampleClientBundle.class);
    
    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource gwtWidgets = RESOURCES.gwtWidgets();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
}

interface GwtWidgetsExampleClientBundle extends ClientBundle {

    @Source("GwtWidgetsExampleDocumentation.html")
    HtmlResource gwtWidgets();

    @Source("GwtWidgetsExample.html")
    HtmlResource demo();

    @Source("com/asayama/gwt/angular/site/examples/GwtWidgetsExample.gwt.xml")
    TextResource config();
    
    @Source("GwtWidgetsExample.java")
    TextResource module();
    
    @Source("GwtWidgetsExampleController.java")
    TextResource controller();
    
    @Source("GwtWidgetsExample.html")
    TextResource view();
}