package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomDirectiveExampleResources extends ClientBundle {

    static CustomDirectiveExampleResources INSTANCE = GWT.create(CustomDirectiveExampleResources.class);

    @Source("com/asayama/gwt/angular/site/examples/CustomDirectiveExample.gwt.xml")
    TextResource config();
    
    @Source("view/CustomDirectiveExample.html")
    HtmlResource customDirective();

    @Source("view/CustomDirectiveDemo.html")
    HtmlResource demo();
    
    @Source("view/CustomDirectiveDemo.html")
    TextResource view();

    @Source("CustomDirectiveExample.java")
    TextResource module();
    
    @Source("directive/MyHello.java")
    TextResource directive();
    
    @Source("directive/MyHello.html")
    TextResource template();

    @Source("CustomDirectiveDemoController.java")
    TextResource controller();
}
