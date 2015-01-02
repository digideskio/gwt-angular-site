package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ProjectResources extends ClientBundle {

    public static final ProjectResources INSTANCE = GWT.create(ProjectResources.class);
    
    @Source("logo-small.png")
    public ImageResource logoSmall();
    
    @Source("logo-large.png")
    ImageResource logoLarge();

    @Source("Documentation.html")
    public HtmlResource documentation();
    
    @Source("Downloads.html")
    public HtmlResource downloads();
    
    @Source("Examples.html")
    public HtmlResource examples();

    @Source("Jumbotron.html")
    public HtmlResource jumbotron();
    
    @Source("Navbar.html")
    public HtmlResource navbar();
    
    @Source("Tutorial.html")
    public HtmlResource tutorial();
}
