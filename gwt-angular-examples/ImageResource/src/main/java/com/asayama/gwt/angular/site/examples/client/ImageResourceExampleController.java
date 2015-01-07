package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;

public class ImageResourceExampleController extends AbstractController {

    private static final ImageResources IMAGES = GWT.create(ImageResources.class);
    
    public static final ImageResource STREET = IMAGES.street();
    public static final ImageResource WTC = IMAGES.wtc();
    public static final ImageResource BOAT = IMAGES.boat();
    public static final ImageResource PEOPLE = IMAGES.people();
    public static final String NOW = String.valueOf(System.currentTimeMillis());
}
