package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class TextInputExampleResources extends AbstractController {

    private static final TextInputExampleClientBundle RESOURCES = GWT.create(TextInputExampleClientBundle.class);

    public static final String DEMO_URL = RESOURCES.demo().getSafeUri().asString();
    public static final HtmlResource textInput = RESOURCES.textInput();
    public static final HtmlResource demo = RESOURCES.demo();
    public static final TextResource config = RESOURCES.config();
    public static final TextResource module = RESOURCES.module();
    public static final TextResource controller = RESOURCES.controller();
    public static final TextResource view = RESOURCES.view();
}

interface TextInputExampleClientBundle extends ClientBundle {

    @Source("TextInputExampleDocumentation.html")
    HtmlResource textInput();

    @Source("TextInputExample.html")
    HtmlResource demo();

    @Source("com/asayama/gwt/angular/site/examples/TextInputExample.gwt.xml")
    TextResource config();

    @Source("TextInputExample.java")
    TextResource module();
    
    @Source("TextInputExampleController.java")
    TextResource controller();
    
    @Source("TextInputExample.html")
    TextResource view();
}
