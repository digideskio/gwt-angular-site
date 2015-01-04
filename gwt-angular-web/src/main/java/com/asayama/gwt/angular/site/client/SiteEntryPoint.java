package com.asayama.gwt.angular.site.client;

import java.util.logging.Handler;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.client.location.LocationProvider;
import com.asayama.gwt.angular.client.sce.SceProvider;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.util.client.SimpleLogFormatter;
import com.asayama.gwt.util.client.SuperDevModeIndicator;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class SiteEntryPoint extends AbstractModule implements EntryPoint {
    
    public static final String CLASS = SiteEntryPoint.class.getName();
    public static final Logger LOG = Logger.getLogger(CLASS);

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
        controller(FooterController.class);
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
                ProjectResources projectResources = GWT.create(ProjectResources.class);
                provider
                    .when(projectResources.documentation(), DocumentationController.class)
                    .when(projectResources.downloads(), DownloadsController.class)
                    .when(projectResources.jumbotron(), JumbotronController.class)
                    .when(projectResources.examples(), ExamplesController.class)
                    .when(projectResources.tutorial(), TutorialController.class)
                    .otherwise(projectResources.jumbotron());
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
        
        run(RootScopeInitializer.class);
        
        Angular.bootstrap();
    }

    /**
     * Registers project scope ($rootScope) constants and resources during 
     * module initialization.
     * 
     * @author kyoken74
     */
    public static class RootScopeInitializer implements Runnable {
        
        @Injector.Inject("$rootScope")
        NGScope scope;
        
        @Override
        public void run() {
            
            // Project Resources
            ProjectResources projectResources = GWT.create(ProjectResources.class);
            scope.put("LOGO_LARGE", projectResources.logoLarge());
            scope.put("LOGO_SMALL", projectResources.logoSmall());
            scope.put("NAVBAR_HTML", projectResources.navbar().getSafeUri().asString());
            scope.put("FOOTER_HTML", projectResources.footer().getSafeUri().asString());

            // Project Constants
            scope.put("ANGULAR_VERSION", Angular.getVersion().getFull());
            scope.put("GWT_VERSION", ProjectConstants.INSTANCE.gwtVersion());
            scope.put("GWT_ANGULAR_VERSION", ProjectConstants.INSTANCE.gwtAngularVersion());
            scope.put("GWT_ANGULAR_SITE_VERSION", ProjectConstants.INSTANCE.gwtAngularSiteVersion());
            scope.put("GITHUB_GWT_ANGULAR_URL", ProjectConstants.INSTANCE.githubGwtAngularUrl());
            scope.put("GITHUB_GWT_ANGULAR_EXAMPLES_URL", ProjectConstants.INSTANCE.githubGwtAngularExamplesUrl());
            scope.put("GITHUB_GWT_ANGULAR_SITE_URL", ProjectConstants.INSTANCE.githubGwtAngularSiteUrl());
            scope.put("GITHUB_GWT_ANGULAR_TUTORIAL_URL", ProjectConstants.INSTANCE.githubGwtAngularTutorialUrl());
            scope.put("SONATYPE_URL", ProjectConstants.INSTANCE.sonatypeUrl());

            // Project Constants - Navigation
            scope.put("DEVELOP", ProjectConstants.INSTANCE.develop());
            scope.put("DOCUMENTATION", ProjectConstants.INSTANCE.documentation());
            scope.put("DOWNLOADS", ProjectConstants.INSTANCE.downloads());
            scope.put("EXAMPLES", ProjectConstants.INSTANCE.examples());
            scope.put("TUTORIAL", ProjectConstants.INSTANCE.tutorial());
        }
    }
}
