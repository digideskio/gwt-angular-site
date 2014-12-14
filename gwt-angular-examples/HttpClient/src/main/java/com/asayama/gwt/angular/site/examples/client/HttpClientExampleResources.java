package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class HttpClientExampleResources implements Controller {

    public static final String DEMO_URL = HttpClientExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource httpClient = HttpClientExampleClientBundle.INSTANCE.httpClient();
    public static final HtmlResource demo = HttpClientExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = HttpClientExampleClientBundle.INSTANCE.config();
    public static final TextResource module = HttpClientExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = HttpClientExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = HttpClientExampleClientBundle.INSTANCE.view();
    
    @Override
    public void onControllerLoad() {
    }
}

interface HttpClientExampleClientBundle extends ClientBundle {

    static final HttpClientExampleClientBundle INSTANCE = GWT.create(HttpClientExampleClientBundle.class);

    @Source("HttpClientExampleDocumentation.html")
    HtmlResource httpClient();

    @Source("HttpClientExample.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/HttpClientExample.gwt.xml")
    TextResource config();
    
    @Source("HttpClientExample.java")
    TextResource module();
    
    @Source("HttpClientExampleController.java")
    TextResource controller();

    @Source("HttpClientExample.html")
    TextResource view();
}
