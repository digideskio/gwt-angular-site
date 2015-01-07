package com.asayama.gwt.angular.site.client;

import com.google.gwt.i18n.client.Constants;


public interface ProjectConstants extends Constants {

    String buildTimestamp();
    String githubGwtAngularUrl();
    String githubGwtAngularExamplesUrl();
    String githubGwtAngularTutorialUrl();
    String githubGwtAngularSiteUrl();
    String javadocUrl();
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
    
    @DefaultStringValue("Javadoc")
    String javadoc();

    @DefaultStringValue("Tutorial")
    String tutorial();
}
