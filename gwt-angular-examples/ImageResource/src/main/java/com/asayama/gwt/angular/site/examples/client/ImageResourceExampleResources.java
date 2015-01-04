package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class ImageResourceExampleResources extends AbstractController {
    
    private static final ImageResources IMAGES = GWT.create(ImageResources.class);
    private static final ImageResourceExampleClientBundle RESOUCES = GWT.create(ImageResourceExampleClientBundle.class);

    
    public static final String DEMO_URL = RESOUCES.demo().getSafeUri().asString();
    public static final String STREET_URL = IMAGES.street().getSafeUri().asString();
    public static final String WTC_URL = IMAGES.wtc().getSafeUri().asString();
    public static final String BOAT_URL = IMAGES.boat().getSafeUri().asString();
    public static final String PEOPLE_URL = IMAGES.people().getSafeUri().asString();

    public static final HtmlResource imageResource = RESOUCES.imageResource();
    public static final HtmlResource demo = RESOUCES.demo();
    public static final TextResource config = RESOUCES.config();
    public static final TextResource module = RESOUCES.module();
    public static final TextResource controller = RESOUCES.controller();
    public static final TextResource resources = RESOUCES.resources();
    public static final TextResource view = RESOUCES.view();
}

interface ImageResourceExampleClientBundle extends ClientBundle {
    
    @Source("ImageResourceExampleDocumentation.html")
    HtmlResource imageResource();

    @Source("ImageResourceExample.html")
    HtmlResource demo();
    
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