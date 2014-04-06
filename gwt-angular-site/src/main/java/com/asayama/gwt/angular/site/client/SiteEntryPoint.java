package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.examples.client.ExamplesController;
import com.asayama.gwt.angular.examples.client.ExamplesResources;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.site.client.controller.DocumentationController;
import com.asayama.gwt.angular.site.client.controller.DownloadsController;
import com.asayama.gwt.angular.site.client.controller.JumbotronController;
import com.asayama.gwt.angular.site.client.controller.NavbarController;
import com.asayama.gwt.angular.tutorial.client.TutorialController;
import com.asayama.gwt.angular.tutorial.client.TutorialResources;
import com.google.gwt.core.client.EntryPoint;

public class SiteEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        controller(DocumentationController.class);
        controller(DownloadsController.class);
        controller(JumbotronController.class);
        controller(NavbarController.class);
        config(RouteProvider.class, new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider routeProvider) {
                routeProvider
                    .when(SiteResources.INSTANCE.documentation(), DocumentationController.class)
                    .when(SiteResources.INSTANCE.downloads(), DownloadsController.class)
                    .when(SiteResources.INSTANCE.jumbotron(), JumbotronController.class)
                    .when(ExamplesResources.INSTANCE.examples(), ExamplesController.class)
                    .when(TutorialResources.INSTANCE.tutorial(), TutorialController.class)
                    .otherwise(SiteResources.INSTANCE.jumbotron());
            }
        });
        Angular.bootstrap();
    }
}