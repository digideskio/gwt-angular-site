package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class CustomDirectiveExampleResources extends AbstractController {

    private static final CustomDirectiveExampleClientBundle RESOURCES = GWT.create(CustomDirectiveExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource customDirective = RESOURCES.customDirective();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
    public static final TextResource directive = RESOURCES.directive();
    public static final TextResource template = RESOURCES.template();
}

interface CustomDirectiveExampleClientBundle extends ClientBundle {

    @Source("CustomDirectiveExampleDocumentation.html")
    HtmlResource customDirective();

    @Source("CustomDirectiveExample.html")
    HtmlResource demo();

    @Source("com/asayama/gwt/angular/site/examples/CustomDirectiveExample.gwt.xml")
    TextResource config();

    @Source("CustomDirectiveExample.java")
    TextResource module();
    
    @Source("CustomDirectiveExampleController.java")
    TextResource controller();
    
    @Source("CustomDirectiveExample.html")
    TextResource view();
    
    @Source("directive/MyHello.java")
    TextResource directive();
    
    @Source("directive/MyHello.html")
    TextResource template();
}
