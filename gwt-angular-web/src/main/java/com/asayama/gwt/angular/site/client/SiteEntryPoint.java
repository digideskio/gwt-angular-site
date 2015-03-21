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
                provider
                    .when("/documentation", "Documentation.html", DocumentationController.class)
                    .when("/downloads", "Downloads.html", DownloadsController.class)
                    .when("/jumbotron", "Jumbotron.html", JumbotronController.class)
                    .when("/examples", "Examples.html", ExamplesController.class)
                    .when("/tutorial", "Tutorial.html", TutorialController.class)
                    .otherwise("/jumbotron");
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
            
            scope.put("LOGO_LARGE", "logo-large.png");
            scope.put("LOGO_SMALL", "logo-small.png");
            scope.put("NAVBAR_HTML", "Navbar.html");
            scope.put("FOOTER_HTML", "Footer.html");

            // Project Constants
            ProjectConstants projectConstants = GWT.create(ProjectConstants.class);
            
            scope.put("ANGULAR_VERSION", Angular.getVersion().getFull());
            scope.put("GWT_VERSION", projectConstants.gwtVersion());
            scope.put("GWT_ANGULAR_VERSION", projectConstants.gwtAngularVersion());
            scope.put("GWT_ANGULAR_SITE_VERSION", projectConstants.gwtAngularSiteVersion());
            scope.put("BUILD_TIMESTAMP", projectConstants.buildTimestamp());
            scope.put("GITHUB_GWT_ANGULAR_URL", projectConstants.githubGwtAngularUrl());
            scope.put("GITHUB_GWT_ANGULAR_EXAMPLES_URL", projectConstants.githubGwtAngularExamplesUrl());
            scope.put("GITHUB_GWT_ANGULAR_SITE_URL", projectConstants.githubGwtAngularSiteUrl());
            scope.put("GITHUB_GWT_ANGULAR_TUTORIAL_URL", projectConstants.githubGwtAngularTutorialUrl());
            scope.put("JAVADOC_URL", projectConstants.javadocUrl());
            scope.put("SONATYPE_URL", projectConstants.sonatypeUrl());

            scope.put("DEVELOP", projectConstants.develop());
            scope.put("DOCUMENTATION", projectConstants.documentation());
            scope.put("DOWNLOADS", projectConstants.downloads());
            scope.put("EXAMPLES", projectConstants.examples());
            scope.put("JAVADOC", projectConstants.javadoc());
            scope.put("TUTORIAL", projectConstants.tutorial());
        }
    }
}
