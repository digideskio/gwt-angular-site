package com.asayama.gwt.angular.site.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;


public interface ProjectConstants extends Constants {

    public static final ProjectConstants INSTANCE = GWT.create(ProjectConstants.class);

    public String githubGwtAngularUrl();
    public String githubGwtAngularExamplesUrl();
    public String githubGwtAngularTutorialUrl();
    public String githubGwtAngularSiteUrl();
    public String sonatypeUrl();
    public String gwtVersion();
    public String gwtAngularVersion();
    public String gwtAngularSiteVersion();
}
