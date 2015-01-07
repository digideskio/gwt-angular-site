package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class HttpClientExampleResources extends AbstractController {

    private static final HttpClientExampleClientBundle RESOURCES = GWT.create(HttpClientExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource httpClient = RESOURCES.httpClient();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
}

interface HttpClientExampleClientBundle extends ClientBundle {

    @Source("HttpClientExampleDocumentation.html")
    HtmlResource httpClient();

    @Source("HttpClientExample.html")
    HtmlResource demo();
    
    @Source("com/asayama/gwt/angular/site/examples/HttpClientExample.gwt.xml")
    TextResource config();
    
    @Source("HttpClientExample.java")
    TextResource module();
    
    @Source("HttpClientExampleController.java")
    TextResource controller();

    @Source("HttpClientExample.html")
    TextResource view();
}
