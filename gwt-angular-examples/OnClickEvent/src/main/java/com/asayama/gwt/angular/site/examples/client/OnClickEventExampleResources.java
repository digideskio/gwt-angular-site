package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class OnClickEventExampleResources extends AbstractController {

    private static final OnClickEventExampleClientBundle RESOURCES = GWT.create(OnClickEventExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource onClickEvent = RESOURCES.onClickEvent();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
}

interface OnClickEventExampleClientBundle extends ClientBundle {

    @Source("OnClickEventExampleDocumentation.html")
    HtmlResource onClickEvent();

    @Source("OnClickEventExample.html")
    HtmlResource demo();

    @Source("com/asayama/gwt/angular/site/examples/OnClickEventExample.gwt.xml")
    TextResource config();
    
    @Source("OnClickEventExample.java")
    TextResource module();
    
    @Source("OnClickEventExampleController.java")
    TextResource controller();
    
    @Source("OnClickEventExample.html")
    TextResource view();
}
