package com.asayama.gwt.angular.site.examples.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.q.Promise.Continue;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.http.client.Response;

public class HttpClientExampleController implements Controller {

    private static final String CLASS = HttpClientExampleController.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    // Fields annotated Injector.Inject are injected by the framework
    @Injector.Inject
    private HttpClient http;

    // Other fields are used to represent the state of this controller
    private JSArray<Mayor> mayors;

    @Override
    public void onControllerLoad() {
        final String url = "HttpClientExample.json";
        http.get(url).then(new Continue<String, Response>() {
            public String call(Response value) {
                int statusCode = value.getStatusCode();
                if (statusCode == 200) {
                    return value.getText();
                }
                LOG.log(Level.WARNING, "[" + statusCode + "] " + url);
                return null;
            }
        }).then(new Continue<JSArray<Mayor>, String>() {
            public JSArray<Mayor> call(String value) {
                return JSArray.eval(value);
            }
        }).then(new Done<JSArray<Mayor>>() {
            public void call(JSArray<Mayor> value) {
                setMayors(value);
            }
        });
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.

    public JSArray<Mayor> getMayors() {
        return mayors;
    }

    public void setMayors(JSArray<Mayor> mayors) {
        this.mayors = mayors;
    }
}

/**
 * Represents a model object.
 */
class Mayor extends JSON {

    protected Mayor() {
    }
    
    public final String getName() {
        return getString("name");
    }
    
    public final String getCity() {
        return getString("city");
    }
}
