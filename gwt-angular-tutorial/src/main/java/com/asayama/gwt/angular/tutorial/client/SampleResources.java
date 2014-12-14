package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface SampleResources extends ClientBundle {

    public static final SampleResources INSTANCE = GWT.create(SampleResources.class);
    
    @Source("Sample.html")
    public HtmlResource sample();
}
