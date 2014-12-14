package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class CustomFilterExampleResources implements Controller {

    public static final String DEMO_URL = CustomFilterExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource customFilter = CustomFilterExampleClientBundle.INSTANCE.customFilter();
    public static final HtmlResource demo = CustomFilterExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = CustomFilterExampleClientBundle.INSTANCE.config();
    public static final TextResource module = CustomFilterExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = CustomFilterExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = CustomFilterExampleClientBundle.INSTANCE.view();
    public static final TextResource filter = CustomFilterExampleClientBundle.INSTANCE.filter();
    
    @Override
    public void onControllerLoad() {
    }
}

interface CustomFilterExampleClientBundle extends ClientBundle {

    static final CustomFilterExampleClientBundle INSTANCE = GWT.create(CustomFilterExampleClientBundle.class);

    @Source("CustomFilterExampleDocumentation.html")
    HtmlResource customFilter();

    @Source("CustomFilterExample.html")
    HtmlResource demo();

    // Core Resources

    @Source("com/asayama/gwt/angular/site/examples/CustomFilterExample.gwt.xml")
    TextResource config();

    @Source("CustomFilterExample.java")
    TextResource module();
    
    @Source("CustomFilterExampleController.java")
    TextResource controller();
    
    @Source("CustomFilterExample.html")
    TextResource view();

    // Other Resources
    
    @Source("filter/Reverse.java")
    TextResource filter();
}

