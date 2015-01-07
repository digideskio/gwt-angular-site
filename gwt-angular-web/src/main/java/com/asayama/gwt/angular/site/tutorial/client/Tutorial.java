package com.asayama.gwt.angular.site.tutorial.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.pages.client.Page;
import com.asayama.gwt.angular.tutorial.client.SampleController;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public class Tutorial extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("tutorial", getPages());
        controller(SampleController.class);
        controller(IntroductionController.class);
        controller(ProjectStructureController.class);
    }
    
    private JSArray<Page> getPages() {
        TutorialResources tutorialResources = GWT.create(TutorialResources.class);
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Introduction", tutorialResources.introduction()));
        pages.add(Page.create("Project Structure", tutorialResources.projectStructure()));
        pages.add(Page.create("Project Object Model", tutorialResources.projectObjectModel()));
        pages.add(Page.create("GWT Module XML", tutorialResources.gwtModuleXML()));
       return pages;
    }
}

interface TutorialResources extends ClientBundle {

    @Source("Introduction.html")
    public HtmlResource introduction();

    @Source("ProjectStructure.html")
    public HtmlResource projectStructure();

    @Source("ProjectObjectModel.html")
    public HtmlResource projectObjectModel();

    @Source("GwtModuleXml.html")
    public HtmlResource gwtModuleXML();
}
