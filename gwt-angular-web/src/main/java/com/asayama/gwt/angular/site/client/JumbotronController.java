package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public class JumbotronController implements Controller {

    public static final ImageResource LOGO = JumbotronResources.INSTANCE.logo();
    public static final String LEARN_MORE = JumbotronConstants.INSTANCE.learnMore();
    public static final String MORE = JumbotronConstants.INSTANCE.more();
    public static final String ANGULAR_VERSION = Angular.getVersion().getFull();
    
    @Override
    public void onControllerLoad() {
    }
}

interface JumbotronConstants extends Constants {

    static JumbotronConstants INSTANCE = GWT.create(JumbotronConstants.class);

    @DefaultStringValue("Learn more »")
    String learnMore();
    
    @DefaultStringValue("More details »")
    String more();
}

interface JumbotronResources extends ClientBundle {
    
    static JumbotronResources INSTANCE = GWT.create(JumbotronResources.class);

    @Source("logo-large.png")
    ImageResource logo();
}
