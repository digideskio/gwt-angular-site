package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;


public class CustomDirectiveExampleController extends AbstractController {

    private String name = null;
    
    @Override
    public void onControllerLoad() {
        this.name = "World";
    }
    
    // Getter and Setter
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
