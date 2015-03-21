package com.asayama.gwt.angular.site.tutorial.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.pages.client.Page;
import com.asayama.gwt.angular.tutorial.client.SampleController;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.client.EntryPoint;


public class Tutorial extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("tutorial", getPages());
        controller(SampleController.class);
        controller(IntroductionController.class);
        controller(ProjectStructureController.class);
    }
    
    private JSArray<Page> getPages() {
//        TutorialResources tutorialResources = GWT.create(TutorialResources.class);
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Introduction", "introduction", "Introduction.html"));
        pages.add(Page.create("Project Structure", "projectStructure", "ProjectStructure.html"));
        pages.add(Page.create("Project Object Model", "projectObjectModel", "ProjectObjectModel.html"));
        pages.add(Page.create("GWT Module XML", "gwtModuleXML", "GwtModuleXml.html"));
       return pages;
    }
}

//interface TutorialResources extends ClientBundle {
//
//    @Source("Introduction.html")
//    public HtmlResource introduction();
//
//    @Source("ProjectStructure.html")
//    public HtmlResource projectStructure();
//
//    @Source("ProjectObjectModel.html")
//    public HtmlResource projectObjectModel();
//
//    @Source("GwtModuleXml.html")
//    public HtmlResource gwtModuleXML();
//}
