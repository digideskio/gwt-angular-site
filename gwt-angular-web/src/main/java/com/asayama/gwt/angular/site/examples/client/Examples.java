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
        controller(CustomDirectiveExampleResources.class);
        controller(CustomFilterExampleResources.class);
        controller(GwtWidgetsExampleResources.class);
        controller(HttpClientExampleResources.class);
        controller(ImageResourceExampleResources.class);
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
        pages.add(Page.create("Custom Directive", CustomDirectiveExampleResources.customDirective));
        pages.add(Page.create("Custom Filter", CustomFilterExampleResources.customFilter));
        pages.add(Page.create("Promise", PromiseExampleResources.promise));
        pages.add(Page.create("Image Resource", ImageResourceExampleResources.imageResource));
        pages.add(Page.create("URL Hash Parameter", UrlHashParameterExampleResources.urlHashParameter));
        pages.add(Page.create("HTTP Client", HttpClientExampleResources.httpClient));
        pages.add(Page.create("GWT Widgets", GwtWidgetsExampleResources.gwtWidgets));
        pages.add(Page.create("Prettify", PrettifyExampleResources.prettify));
       return pages;
    }
}

