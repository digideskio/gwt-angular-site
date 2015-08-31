package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.jsni.client.JSON;

/**
 * Represents a model object.
 */
class Greeting extends JSON {

    protected Greeting() {
    }

    public final String getLanguage() {
        return getString("language");
    }

    public final String getGreeting() {
        return getString("greeting");
    }
}
