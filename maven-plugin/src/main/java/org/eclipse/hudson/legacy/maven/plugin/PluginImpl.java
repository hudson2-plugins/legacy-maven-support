/*******************************************************************************
 *
 * Copyright (c) 2004-2009 Oracle Corporation.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: 
*
*    Tom Huybrechts
 *     
 *
 *******************************************************************************/ 

package org.eclipse.hudson.legacy.maven.plugin;

import hudson.Plugin;
import hudson.XmlFile;
import hudson.maven.MavenModuleSet;
import hudson.model.Items;
import org.eclipse.hudson.legacy.maven.plugin.MavenModuleSet.DescriptorImpl;

/**
 * @author huybrechts
 */
public class PluginImpl extends Plugin {
    @Override
    public void start() throws Exception {
        setXtreamAliasForBackwardCompatibility();
    }
    
    /**
     * Register XStream aliases for backward compatibility - should be removed eventually
     */
    public static void setXtreamAliasForBackwardCompatibility(){
        XmlFile.DEFAULT_XSTREAM.alias("hudson.maven.MavenModuleSet$DescriptorImpl", DescriptorImpl.class);
        
        Items.XSTREAM.alias("maven2", MavenModule.class);
        Items.XSTREAM.alias("dependency", ModuleDependency.class);
        Items.XSTREAM.alias("maven2-module-set", MavenModule.class);  // this was a bug, but now we need to keep it for compatibility
        Items.XSTREAM.alias("maven2-moduleset", MavenModuleSet.class);
    }

}
