package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;

public class UrlHashParameterExampleController implements Controller {

    // Fields annotated Injector.Inject are injected by the framework
    
    @Injector.Inject
    private RouteParams routeParams;

    @Injector.Inject
    private Location location;

    // Other fields are used to represent the state of this controller

    private String page;

    @Override
    public void onControllerLoad() {
        page = routeParams.getString("page");
    }

    // Public methods are automatically wired to AngularJS's $scope.

    public void onClickGo(String page) {
        location.setHashParam("page", page);
    }

    public String getName() {
        return page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
}
