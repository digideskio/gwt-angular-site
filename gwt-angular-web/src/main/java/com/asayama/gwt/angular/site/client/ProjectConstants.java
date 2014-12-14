package com.asayama.gwt.angular.site.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;


public interface ProjectConstants extends Constants {

    public static final ProjectConstants INSTANCE = GWT.create(ProjectConstants.class);
    
    public String projectGroupId();
    public String projectArtifactId();
    public String projectVersion();
    public String projectUrl();
    
    public String githubArchiveUrl();
    public String githubBlobUrl();
    public String githubIssueUrl();
    public String githubTreeUrl();
    
    public String sonatypeSearchUrl();
}
