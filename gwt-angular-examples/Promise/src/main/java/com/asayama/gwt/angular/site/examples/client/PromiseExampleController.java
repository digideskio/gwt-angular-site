package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.q.Progress;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.client.q.Promise.Fail;
import com.asayama.gwt.angular.client.q.Promise.Notify;
import com.asayama.gwt.angular.site.examples.client.service.GreetingService;

public class PromiseExampleController extends AbstractController {

    // Our custom service to demonstrate promise pipelining.
    @Injector.Inject
    private GreetingService service;
    
    // View Models
    private String buttonCaption = "Go";
    private String greeting = "Click " + getButtonCaption();
    
    public void onClickGo() {
        setGreeting("Loading...");
        Promise<String> promise = service.getGreeting();
        promise.then(new Done<String>() {
            // Refreshes the greeting model and update the button caption.
            @Override
            public void call(String value) {
                setGreeting(value);
                setButtonCaption("Go Again");
            }
        }).then(new Notify() {
            @Override
            public void call(Progress progress) {
                setGreeting(progress.getMessage());
            }
        }).then(new Fail() {
            @Override
            public void call(Throwable cause) {
                setGreeting(cause.getMessage());
            }
        });
    }

    // Getters and Setters
    
    public String getGreeting() {
        return greeting;
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
    public String getButtonCaption() {
        return buttonCaption;
    }
    
    public void setButtonCaption(String buttonCaption) {
        this.buttonCaption = buttonCaption;
    }
}
