package com.asayama.gwt.angular.rebind;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.rebind.exceptions.RebindException;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

abstract class AbstractGenerator extends Generator {

    private static final String CLASS = AbstractGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    abstract String getFilename();

    protected JClassType getClassType(GeneratorContext context, String qualifiedClassName) throws RebindException {

        final String METHOD = "getClassType(GeneratorContext, String)";
        
        JClassType classType = null;
        try {
            TypeOracle typeOracle = context.getTypeOracle();
            classType = typeOracle.getType(qualifiedClassName);
        } catch (NotFoundException e) {
            String m = qualifiedClassName + " was not found";
            LOG.logp(Level.SEVERE, CLASS, METHOD, m);
            throw new RebindException(m);
        }
        return classType;
    }
    
}
