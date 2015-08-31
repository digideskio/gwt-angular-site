package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.http.client.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyService implements Service {

    private static final String CLASS = MyService.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    public static interface Callback {
        public void onSuccess(JSArray<Greeting> value);
    }

    @Injector.Inject
    private HttpClient http;

    public void getGreetings(final Callback callback) {
        final String url = "ServiceInjectionExample.json";
        http.get(url).then(new Promise.Continue<String, Response>() {
            public String call(Response value) {
                int statusCode = value.getStatusCode();
                if (statusCode == 200) {
                    return value.getText();
                }
                LOG.log(Level.WARNING, "[" + statusCode + "] " + url);
                return null;
            }
        }).then(new Promise.Continue<JSArray<Greeting>, String>() {
            public JSArray<Greeting> call(String value) {
                return JSArray.eval(value);
            }
        }).then(new Promise.Done<JSArray<Greeting>>() {
            public void call(JSArray<Greeting> value) {
                callback.onSuccess(value);
            }
        });

    }
}
