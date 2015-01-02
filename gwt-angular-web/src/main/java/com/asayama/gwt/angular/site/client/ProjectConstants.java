package com.asayama.gwt.angular.site.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;


public interface ProjectConstants extends Constants {

    public static final ProjectConstants INSTANCE = GWT.create(ProjectConstants.class);

    String githubGwtAngularUrl();
    String githubGwtAngularExamplesUrl();
    String githubGwtAngularTutorialUrl();
    String githubGwtAngularSiteUrl();
    String sonatypeUrl();
    String gwtVersion();
    String gwtAngularVersion();
    String gwtAngularSiteVersion();

    @DefaultStringValue("Develop")
    String develop();

    @DefaultStringValue("Documenation")
    String documentation();

    @DefaultStringValue("Downloads")
    String downloads();

    @DefaultStringValue("Examples")
    String examples();

    @DefaultStringValue("Tutorial")
    String tutorial();
}
