package com.asayama.gwt.angular.site.tutorial.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.angular.tutorial.client.SampleResources;
import com.google.gwt.core.client.GWT;


public class IntroductionController extends AbstractController {

    private static final SampleResources RESOURCES = GWT.create(SampleResources.class);
    public static final String DEMO_URL = RESOURCES.sample().getSafeUri().asString();
}
