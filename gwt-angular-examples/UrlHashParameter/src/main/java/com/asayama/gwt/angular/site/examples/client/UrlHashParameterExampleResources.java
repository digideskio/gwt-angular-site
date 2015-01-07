package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class UrlHashParameterExampleResources extends AbstractController {

    private static final UrlHashParameterExampleClientBundle RESOURCES = GWT.create(UrlHashParameterExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource urlHashParameter = RESOURCES.urlHashParameter();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
}

interface UrlHashParameterExampleClientBundle extends ClientBundle {

    @Source("UrlHashParameterExampleDocumentation.html")
    HtmlResource urlHashParameter();

    @Source("UrlHashParameterExample.html")
    HtmlResource demo();
    
    @Source("com/asayama/gwt/angular/site/examples/UrlHashParameterExample.gwt.xml")
    TextResource config();
    
    @Source("UrlHashParameterExample.java")
    TextResource module();
    
    @Source("UrlHashParameterExampleController.java")
    TextResource controller();

    @Source("UrlHashParameterExample.html")
    TextResource view();
}
