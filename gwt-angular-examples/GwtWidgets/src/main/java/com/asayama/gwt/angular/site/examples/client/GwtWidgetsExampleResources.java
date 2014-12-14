package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class GwtWidgetsExampleResources implements Controller {

    public static final String DEMO_URL = GwtWidgetsExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource gwtWidgets = GwtWidgetsExampleClientBundle.INSTANCE.gwtWidgets();
    public static final HtmlResource demo = GwtWidgetsExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = GwtWidgetsExampleClientBundle.INSTANCE.config();
    public static final TextResource module = GwtWidgetsExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = GwtWidgetsExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = GwtWidgetsExampleClientBundle.INSTANCE.view();
    
    @Override
    public void onControllerLoad() {
    }
}

interface GwtWidgetsExampleClientBundle extends ClientBundle {

    static final GwtWidgetsExampleClientBundle INSTANCE = GWT.create(GwtWidgetsExampleClientBundle.class);
    
    @Source("GwtWidgetsExampleDocumentation.html")
    HtmlResource gwtWidgets();

    @Source("GwtWidgetsExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/GwtWidgetsExample.gwt.xml")
    TextResource config();
    
    @Source("GwtWidgetsExample.java")
    TextResource module();
    
    @Source("GwtWidgetsExampleController.java")
    TextResource controller();
    
    @Source("GwtWidgetsExample.html")
    TextResource view();
}