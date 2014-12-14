package com.asayama.gwt.angular.site.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageResources extends ClientBundle {
    
    static ImageResources INSTANCE = GWT.create(ImageResources.class);
    
    @Source("street.jpg")
    ImageResource street();
    
    @Source("wtc.jpg")
    ImageResource wtc();
    
    @Source("boat.jpg")
    ImageResource boat();
    
    @Source("people.jpg")
    ImageResource people();
}

