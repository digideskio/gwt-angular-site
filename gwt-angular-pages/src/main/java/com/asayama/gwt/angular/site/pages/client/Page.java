package com.asayama.gwt.angular.site.pages.client;

import com.asayama.gwt.jsni.client.JSON;
import com.asayama.gwt.resources.client.HtmlResource;


public class Page extends JSON {
    
    public static Page create(String title, HtmlResource partial) {
        return create(title, partial.getName(), partial.getSafeUri().asString());
    }
    
    public static Page create(String title, String name, String url) {
        Page page = create();
        page.put("name", name);
        page.put("title", title);
        page.put("url", url);
        return page;
    }
    
    protected Page() {
    }
    
    public final String getName() {
        return getString("name");
    }
}
