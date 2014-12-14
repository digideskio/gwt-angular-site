package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.ImageResource;

public class ImageResourceExampleController implements Controller {

    public static final ImageResource STREET = ImageResources.INSTANCE.street();
    public static final ImageResource WTC = ImageResources.INSTANCE.wtc();
    public static final ImageResource BOAT = ImageResources.INSTANCE.boat();
    public static final ImageResource PEOPLE = ImageResources.INSTANCE.people();
    public static final String NOW = String.valueOf(System.currentTimeMillis());
    
    @Override
    public void onControllerLoad() {
        //noop
    }
}
