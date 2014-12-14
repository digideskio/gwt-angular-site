package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class ImageResourceExampleResources implements Controller {
    
    public static final String DEMO_URL = ImageResourceExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final String STREET_URL = ImageResources.INSTANCE.street().getSafeUri().asString();
    public static final String WTC_URL = ImageResources.INSTANCE.wtc().getSafeUri().asString();
    public static final String BOAT_URL = ImageResources.INSTANCE.boat().getSafeUri().asString();
    public static final String PEOPLE_URL = ImageResources.INSTANCE.people().getSafeUri().asString();

    public static final HtmlResource imageResource = ImageResourceExampleClientBundle.INSTANCE.imageResource();
    public static final HtmlResource demo = ImageResourceExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = ImageResourceExampleClientBundle.INSTANCE.config();
    public static final TextResource module = ImageResourceExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = ImageResourceExampleClientBundle.INSTANCE.controller();
    public static final TextResource resources = ImageResourceExampleClientBundle.INSTANCE.resources();
    public static final TextResource view = ImageResourceExampleClientBundle.INSTANCE.view();
    
    @Override
    public void onControllerLoad() {
    }
}

interface ImageResourceExampleClientBundle extends ClientBundle {
    
    static final ImageResourceExampleClientBundle INSTANCE = GWT.create(ImageResourceExampleClientBundle.class);

    @Source("ImageResourceExampleDocumentation.html")
    HtmlResource imageResource();

    @Source("ImageResourceExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/ImageResourceExample.gwt.xml")
    TextResource config();
    
    @Source("ImageResourceExample.java")
    TextResource module();

    @Source("ImageResourceExampleController.java")
    TextResource controller();

    @Source("ImageResources.java")
    TextResource resources();
    
    @Source("ImageResourceExample.html")
    TextResource view();
}