package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class TextInputExampleController implements Controller {

    public static final String DEMO_URL =
            TextInputExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.java().getText());

    // Public final fields are directly bound to AngularJS's $scope, and they 
    // are available for use in the HTML.
    
    public static final String GREETING = "Hello";
    public static final String STRANGER = "Stranger";

    // Other fields are used to represent the state of this controller.
    
    private String name = null;

    @Override
    public void onControllerLoad() {
        //noop
    }

    // Public methods are automatically wired to AngularJS's $scope, and
    // they are availabe for use in the HTML.
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

interface TextInputExampleResources extends ClientBundle {
    
    static final TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("TextInputExampleDemo.html")
    public DataResource demo();
    
    @Source("TextInputExampleDemo.html")
    public TextResource html();
    
    @Source("TextInputExampleController.java")
    public TextResource java();
}