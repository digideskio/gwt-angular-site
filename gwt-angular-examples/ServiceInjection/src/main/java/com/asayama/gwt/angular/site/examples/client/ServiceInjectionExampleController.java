package com.asayama.gwt.angular.site.examples.client;

import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.jsni.client.JSArray;

public class ServiceInjectionExampleController extends AbstractController {

    private static final String CLASS = ServiceInjectionExampleController.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    // Fields annotated Injector.Inject are injected by the framework
    @Injector.Inject
    private MyService myService;

    // Other fields are used to represent the state of this controller
    private JSArray<Greeting> greetings;

    @Override
    public void onControllerLoad() {
        myService.getGreetings(new MyService.Callback() {
            @Override
            public void onSuccess(JSArray<Greeting> value) {
                setGreetings(value);
            }
        });
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.

    public JSArray<Greeting> getGreetings() {
        return greetings;
    }

    public void setGreetings(JSArray<Greeting> greetings) {
        this.greetings = greetings;
    }
}

