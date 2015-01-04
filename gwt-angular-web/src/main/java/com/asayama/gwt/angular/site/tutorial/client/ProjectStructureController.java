package com.asayama.gwt.angular.site.tutorial.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public class ProjectStructureController extends AbstractController {

    public static final ImageResource PROJECT_STRUCTURE_IMAGE = ProjectStructureControllerResources.INSTANCE.projectStructureImage();
    
}

interface ProjectStructureControllerResources extends ClientBundle {

    static ProjectStructureControllerResources INSTANCE = GWT.create(ProjectStructureControllerResources.class);
    
    @Source("ProjectStructure.png")
    public ImageResource projectStructureImage();
}