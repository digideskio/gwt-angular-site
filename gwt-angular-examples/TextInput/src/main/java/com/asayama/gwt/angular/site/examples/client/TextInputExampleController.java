package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;

public class TextInputExampleController extends AbstractController {

    // Public final fields are directly bound to AngularJS's $scope, and they 
    // are available for use in the HTML.
    
    public static final String GREETING = "Hello";
    public static final String STRANGER = "Stranger";

    // Other fields are used to represent the state of this controller.
    
    private String name = null;

    // Public methods are automatically wired to AngularJS's $scope, and
    // they are available for use in the HTML.
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
