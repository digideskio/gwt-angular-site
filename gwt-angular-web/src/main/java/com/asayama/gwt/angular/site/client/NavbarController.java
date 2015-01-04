package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.site.pages.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.user.client.Window;

public class NavbarController extends AbstractController {

    @Injector.Inject("examples")
    private JSArray<Page> examples = null;

    @Injector.Inject("tutorial")
    private JSArray<Page> tutorial = null;
    
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
