package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public class JumbotronController implements Controller {

    public static final String LEARN_MORE = JumbotronConstants.INSTANCE.learnMore();
    public static final String MORE = JumbotronConstants.INSTANCE.more();
    
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
