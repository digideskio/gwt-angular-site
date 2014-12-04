package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.TextResource;


public interface ImageResourceExampleResources extends ClientResources {
    
    static final ImageResourceExampleResources INSTANCE = GWT.create(ImageResourceExampleResources.class);

    static final String DEMO_URL = ImageResourceExampleResources.INSTANCE.demo().getSafeUri().asString();
    static final String STREET_URL = ImageResources.INSTANCE.street().getSafeUri().asString();
    static final String WTC_URL = ImageResources.INSTANCE.wtc().getSafeUri().asString();
    static final String BOAT_URL = ImageResources.INSTANCE.boat().getSafeUri().asString();
    static final String PEOPLE_URL = ImageResources.INSTANCE.people().getSafeUri().asString();

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
