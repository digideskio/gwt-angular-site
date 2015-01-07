package com.asayama.gwt.angular.site.tutorial.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public class ProjectStructureController extends AbstractController {

    private static ProjectStructureControllerResources RESOURCES = GWT.create(ProjectStructureControllerResources.class);
    public static final ImageResource PROJECT_STRUCTURE_IMAGE = RESOURCES.projectStructureImage();
}

interface ProjectStructureControllerResources extends ClientBundle {

    @Source("ProjectStructure.png")
    public ImageResource projectStructureImage();
}
