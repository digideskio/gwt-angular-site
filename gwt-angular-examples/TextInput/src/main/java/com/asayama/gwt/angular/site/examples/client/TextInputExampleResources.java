package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class TextInputExampleResources implements Controller {

    public static final String DEMO_URL = TextInputExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource textInput = TextInputExampleClientBundle.INSTANCE.textInput();
    public static final HtmlResource demo = TextInputExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = TextInputExampleClientBundle.INSTANCE.config();
    public static final TextResource module = TextInputExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = TextInputExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = TextInputExampleClientBundle.INSTANCE.view();
    
    @Override
    public void onControllerLoad() {
    }
}

interface TextInputExampleClientBundle extends ClientBundle {

    static final TextInputExampleClientBundle INSTANCE = GWT.create(TextInputExampleClientBundle.class);

    @Source("TextInputExampleDocumentation.html")
    HtmlResource textInput();

    @Source("TextInputExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/TextInputExample.gwt.xml")
    TextResource config();

    @Source("TextInputExample.java")
    TextResource module();
    
    @Source("TextInputExampleController.java")
    TextResource controller();
    
    @Source("TextInputExample.html")
    TextResource view();
}
