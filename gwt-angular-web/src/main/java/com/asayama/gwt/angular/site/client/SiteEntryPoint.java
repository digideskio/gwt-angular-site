package com.asayama.gwt.angular.site.client;

import java.util.logging.Handler;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.client.location.LocationProvider;
import com.asayama.gwt.angular.client.sce.SceProvider;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.util.client.SimpleLogFormatter;
import com.asayama.gwt.util.client.SuperDevModeIndicator;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class SiteEntryPoint extends AbstractModule implements EntryPoint {

    static {
        SimpleLogFormatter formatter = new SimpleLogFormatter();
        Handler[] handlers = Logger.getLogger("").getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(formatter);
        }
    }
    
    public void onModuleLoad() {
        
        Angular.module(this);
        controller(DocumentationController.class);
        controller(DownloadsController.class);
        controller(ExamplesController.class);
        controller(JumbotronController.class);
        controller(NavbarController.class);
        controller(TutorialController.class);
        
        config(LocationProvider.class, new Configurator<LocationProvider>() {
            public void configure(LocationProvider provider) {
                provider.hashPrefix("!");
            }
        });
        
        config(RouteProvider.class, new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider provider) {
                provider
                    .when(NavbarResources.INSTANCE.documentation(), DocumentationController.class)
                    .when(NavbarResources.INSTANCE.downloads(), DownloadsController.class)
                    .when(NavbarResources.INSTANCE.jumbotron(), JumbotronController.class)
                    .when(NavbarResources.INSTANCE.examples(), ExamplesController.class)
                    .when(NavbarResources.INSTANCE.tutorial(), TutorialController.class)
                    .otherwise(NavbarResources.INSTANCE.jumbotron());
            }
        });
        
        config(SceProvider.class, new Configurator<SceProvider>() {
            @Override
            public void configure(SceProvider provider) {
                // This is a workaround for supporting SuperDevMode via Eclipse
                // plugin. ngInclude requires that the included HTML is trusted
                // as per SCE policy. When we run the App in SuperDevMode via
                // Eclipse plugin, we are unable to load the page because we
                // first load in port 8888, which then gets redirected to 9876.
                // SCE does not like loading resources even when we are loading
                // from the same server, if the port number is different. We
                // turn off the SCE when we are not running in Prod mode.
                SuperDevModeIndicator sdm = GWT.create(SuperDevModeIndicator.class);
                provider.enabled(!sdm.isSuperDevMode());
            }
        });
        
        Angular.bootstrap();
    }
}
