package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public class JumbotronController extends AbstractController {

    private static final JumbotronConstants CONSTANTS = GWT.create(JumbotronConstants.class);
    public static final String LEARN_MORE = CONSTANTS.learnMore();
    public static final String MORE = CONSTANTS.more();
}

interface JumbotronConstants extends Constants {

    @DefaultStringValue("Learn more »")
    String learnMore();
    
    @DefaultStringValue("More details »")
    String more();
}
