package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public class DocumentationController implements Controller {

    public static final ImageResource MVC = DocumentationResources.INSTANCE.mvc();

    @Override
    public void onControllerLoad() {
    }
}

interface DocumentationResources extends ClientBundle {
    
    static DocumentationResources INSTANCE = GWT.create(DocumentationResources.class);

    @Source("mvc.png")
    ImageResource mvc();
}