package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.pages.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class Examples extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        controller(OnClickEventExampleResources.class);
        controller(PrettifyExampleResources.class);
        controller(PromiseExampleResources.class);
        controller(TextInputExampleResources.class);
        controller(UrlHashParameterExampleResources.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Text Input", TextInputExampleResources.textInput));
        pages.add(Page.create("OnClick Event", OnClickEventExampleResources.onClickEvent));
        pages.add(Page.create("Custom Directive", "customDirective", "CustomDirectiveExampleDocumentation.html"));
        pages.add(Page.create("Custom Filter", "customFilter", "CustomFilterExampleDocumentation.html"));
        pages.add(Page.create("Promise", PromiseExampleResources.promise));
        pages.add(Page.create("Image Resource", "imageResource", "ImageResourceExampleDocumentation.html"));
        pages.add(Page.create("URL Hash Parameter", UrlHashParameterExampleResources.urlHashParameter));
        pages.add(Page.create("HTTP Client", "httpClient", "HttpClientExampleDocumentation.html"));
        pages.add(Page.create("GWT Widgets", "gwtWidgets", "GwtWidgetsExampleDocumentation.html"));
        pages.add(Page.create("Prettify", PrettifyExampleResources.prettify));
       return pages;
    }
}

