package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public class DocumentationController extends AbstractController {

    private static final DocumentationResources RESOURCES = GWT.create(DocumentationResources.class);
    public static final ImageResource MVC = RESOURCES.mvc();
}

interface DocumentationResources extends ClientBundle {
    
    @Source("mvc.png")
    ImageResource mvc();
}
