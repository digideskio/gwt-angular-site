package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.AbstractController;

public class FooterController extends AbstractController {

    public String getDate() {
        return String.valueOf(System.currentTimeMillis());
    }
}
