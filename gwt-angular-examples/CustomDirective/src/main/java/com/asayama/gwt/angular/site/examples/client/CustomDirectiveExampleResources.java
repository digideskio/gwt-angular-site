package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class CustomDirectiveExampleResources implements Controller {

    public static final String DEMO_URL = CustomDirectiveExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource customDirective = CustomDirectiveExampleClientBundle.INSTANCE.customDirective();
    public static final HtmlResource demo = CustomDirectiveExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = CustomDirectiveExampleClientBundle.INSTANCE.config();
    public static final TextResource module = CustomDirectiveExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = CustomDirectiveExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = CustomDirectiveExampleClientBundle.INSTANCE.view();
    public static final TextResource directive = CustomDirectiveExampleClientBundle.INSTANCE.directive();
    public static final TextResource template = CustomDirectiveExampleClientBundle.INSTANCE.template();
    
    @Override
    public void onControllerLoad() {
    }
}

interface CustomDirectiveExampleClientBundle extends ClientBundle {

    static final CustomDirectiveExampleClientBundle INSTANCE = GWT.create(CustomDirectiveExampleClientBundle.class);

    @Source("CustomDirectiveExampleDocumentation.html")
    HtmlResource customDirective();

    @Source("CustomDirectiveExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/CustomDirectiveExample.gwt.xml")
    TextResource config();

    @Source("CustomDirectiveExample.java")
    TextResource module();
    
    @Source("CustomDirectiveExampleController.java")
    TextResource controller();
    
    @Source("CustomDirectiveExample.html")
    TextResource view();
    
    // Other Resources

    @Source("directive/MyHello.java")
    TextResource directive();
    
    @Source("directive/MyHello.html")
    TextResource template();
}
