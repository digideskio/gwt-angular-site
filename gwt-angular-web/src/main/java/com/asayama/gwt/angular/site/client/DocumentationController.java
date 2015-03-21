package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.AbstractController;

public class DocumentationController extends AbstractController {

//    private static final DocumentationResources RESOURCES = GWT.create(DocumentationResources.class);
    public static final String MVC = "mvc.png"; //RESOURCES.mvc();
    
    public String getStyleClass() {
        return "scaleInOut";
    }
}

//interface DocumentationResources extends ClientBundle {
//    
//    @Source("mvc.png")
//    ImageResource mvc();
//}
