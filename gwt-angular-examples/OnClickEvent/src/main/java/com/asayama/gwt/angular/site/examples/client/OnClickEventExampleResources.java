package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class OnClickEventExampleResources implements Controller {

    public static final String DEMO_URL = OnClickEventExampleClientBundle.INSTANCE.demo().getSafeUri().asString();
    public static final HtmlResource onClickEvent = OnClickEventExampleClientBundle.INSTANCE.onClickEvent();
    public static final HtmlResource demo = OnClickEventExampleClientBundle.INSTANCE.demo();
    public static final TextResource config = OnClickEventExampleClientBundle.INSTANCE.config();
    public static final TextResource module = OnClickEventExampleClientBundle.INSTANCE.module();
    public static final TextResource controller = OnClickEventExampleClientBundle.INSTANCE.controller();
    public static final TextResource view = OnClickEventExampleClientBundle.INSTANCE.view();

    public void onControllerLoad() {
    }
}

interface OnClickEventExampleClientBundle extends ClientBundle {

    static final OnClickEventExampleClientBundle INSTANCE = GWT.create(OnClickEventExampleClientBundle.class);

    @Source("OnClickEventExampleDocumentation.html")
    HtmlResource onClickEvent();

    @Source("OnClickEventExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/OnClickEventExample.gwt.xml")
    TextResource config();
    
    @Source("OnClickEventExample.java")
    TextResource module();
    
    @Source("OnClickEventExampleController.java")
    TextResource controller();
    
    @Source("OnClickEventExample.html")
    TextResource view();
}
