package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class PrettifyExampleController extends AbstractController {

    public static final TextResource VIEW_CODE = MyResources.INSTANCE.view();

}

interface MyResources extends ClientBundle {

    static final MyResources INSTANCE = GWT.create(MyResources.class);
    
    @Source("PrettifyExample.html")
    TextResource view();
}