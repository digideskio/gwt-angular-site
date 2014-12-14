package com.asayama.gwt.angular.site.tutorial.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.tutorial.client.SampleResources;


public class IntroductionController implements Controller {

    public static final String DEMO_URL = SampleResources.INSTANCE.sample().getSafeUri().asString();
    
    @Override
    public void onControllerLoad() {
    }
}
