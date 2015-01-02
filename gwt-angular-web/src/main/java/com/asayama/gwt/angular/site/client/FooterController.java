package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class FooterController implements Controller {

    public static final String FOOTER_HTML = FooterResources.INSTANCE.footer().getSafeUri().asString();

    @Override
    public void onControllerLoad() {
    }

    public String getDate() {
        return String.valueOf(System.currentTimeMillis());
    }
}

interface FooterResources extends ClientBundle {
    
    public static final FooterResources INSTANCE = GWT.create(FooterResources.class);

    @Source("Footer.html")
    public HtmlResource footer();
}