package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class UrlHashParameterExampleResources implements Controller {

    public static final String DEMO_URL = UrlHashParameterExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource urlHashParameter = UrlHashParameterExampleClientBundle.INSTANCE.urlHashParameter();
    public static final HtmlResource demo = UrlHashParameterExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = UrlHashParameterExampleClientBundle.INSTANCE.config();
    public static final TextResource module = UrlHashParameterExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = UrlHashParameterExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = UrlHashParameterExampleClientBundle.INSTANCE.view();
    
    @Override
    public void onControllerLoad() {
    }
}

interface UrlHashParameterExampleClientBundle extends ClientBundle {

    static final UrlHashParameterExampleClientBundle INSTANCE = GWT.create(UrlHashParameterExampleClientBundle.class);

    @Source("UrlHashParameterExampleDocumentation.html")
    HtmlResource urlHashParameter();

    @Source("UrlHashParameterExample.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/UrlHashParameterExample.gwt.xml")
    TextResource config();
    
    @Source("UrlHashParameterExample.java")
    TextResource module();
    
    @Source("UrlHashParameterExampleController.java")
    TextResource controller();

    @Source("UrlHashParameterExample.html")
    TextResource view();
}
