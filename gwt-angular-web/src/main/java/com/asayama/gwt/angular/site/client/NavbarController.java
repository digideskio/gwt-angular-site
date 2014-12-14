package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.site.pages.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;

public class NavbarController implements Controller {

    public static final ImageResource LOGO = NavbarResources.INSTANCE.logo();

    public static final String NAVBAR_HTML = NavbarResources.INSTANCE.navbar().getSafeUri().asString();
    public static final String FOOTER_HTML = NavbarResources.INSTANCE.footer().getSafeUri().asString();

    public static final String PROJECT_GROUP_ID = ProjectConstants.INSTANCE.projectGroupId();
    public static final String PROJECT_ARTIFACT_ID = ProjectConstants.INSTANCE.projectArtifactId();
    public static final String PROJECT_VERSION = ProjectConstants.INSTANCE.projectVersion();
    public static final String PROJECT_URL = ProjectConstants.INSTANCE.projectUrl();
    
    @Deprecated
    public static final String GITHUB_SOURCE_URL = ProjectConstants.INSTANCE.githubTreeUrl();
    public static final String GITHUB_ARCHIVE_URL = ProjectConstants.INSTANCE.githubArchiveUrl();
    public static final String GITHUB_BLOB_URL = ProjectConstants.INSTANCE.githubBlobUrl();
    public static final String GITHUB_ISSUE_URL = ProjectConstants.INSTANCE.githubIssueUrl();
    public static final String GITHUB_TREE_URL = ProjectConstants.INSTANCE.githubTreeUrl();
    public static final String SONATYPE_SEARCH_URL = ProjectConstants.INSTANCE.sonatypeSearchUrl();
    
    public static final String DEVELOP = NavbarConstants.INSTANCE.develop();
    public static final String DOCUMENTATION = NavbarConstants.INSTANCE.documentation();
    public static final String DOWNLOADS = NavbarConstants.INSTANCE.downloads();
    public static final String EXAMPLES = NavbarConstants.INSTANCE.examples();
    public static final String TUTORIAL = NavbarConstants.INSTANCE.tutorial();

    @Injector.Inject("examples")
    private JSArray<Page> examples = null;

    @Injector.Inject("tutorial")
    private JSArray<Page> tutorial = null;
    
    @Override
    public void onControllerLoad() {
    }
    
    public String getStyleNavlinkDownloads() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/downloads") ? "active" : "";
    }

    public String getStyleNavlinkExamples() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/examples") ? "active" : "";
    }

    public String getStyleNavlinkHome() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/jumbotron") ? "active" : "";
    }

    public String getStyleNavlinkDocumentation() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/documentation") ? "active" : "";
    }
    
    public String getStyleNavlinkTutorial() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/tutorial") ? "active" : "";
    }
    
    public JSArray<Page> getExamples() {
        return examples;
    }
    
    public JSArray<Page> getTutorial() {
        return tutorial;
    }
}

interface NavbarConstants extends Constants {

    static NavbarConstants INSTANCE = GWT.create(NavbarConstants.class);

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

interface NavbarResources extends ClientBundle {
    
    public static final NavbarResources INSTANCE = GWT.create(NavbarResources.class);

    @Source("logo-small.png")
    public ImageResource logo();
    
    @Source("Documentation.html")
    public HtmlResource documentation();
    
    @Source("Downloads.html")
    public HtmlResource downloads();
    
    @Source("Examples.html")
    public HtmlResource examples();

    @Source("Footer.html")
    public HtmlResource footer();

    @Source("Jumbotron.html")
    public HtmlResource jumbotron();
    
    @Source("Navbar.html")
    public HtmlResource navbar();
    
    @Source("Tutorial.html")
    public HtmlResource tutorial();
    
}
