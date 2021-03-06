/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2008 Sun Microsystems, Inc.
 */
package org.netbeans.modules.maven.j2ee.ear;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.modules.maven.api.NbMavenProject;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.modules.j2ee.api.ejbjar.Ear;
import org.netbeans.modules.j2ee.deployment.devmodules.api.J2eeModule;
import org.netbeans.modules.j2ee.deployment.devmodules.api.ModuleChangeReporter;
import org.netbeans.modules.j2ee.deployment.devmodules.spi.ArtifactListener;
import org.netbeans.modules.j2ee.deployment.devmodules.spi.ArtifactListener.Artifact;
import org.netbeans.modules.j2ee.deployment.devmodules.spi.J2eeApplicationProvider;
import org.netbeans.modules.j2ee.deployment.devmodules.spi.J2eeModuleFactory;
import org.netbeans.modules.j2ee.deployment.devmodules.spi.J2eeModuleProvider;
import org.netbeans.modules.j2ee.spi.ejbjar.EarImplementation2;
import org.netbeans.modules.j2ee.spi.ejbjar.EarProvider;
import org.netbeans.modules.j2ee.spi.ejbjar.EjbJarFactory;
import org.netbeans.modules.maven.api.classpath.ProjectSourcesClassPathProvider;
import org.netbeans.modules.maven.api.execute.RunUtils;
import org.netbeans.modules.maven.j2ee.execution.ExecutionChecker;
import org.netbeans.modules.maven.j2ee.utils.MavenProjectSupport;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;

/**
 * provider for ear specific functionality
 * @author  Milos Kleint
 */
@ProjectServiceProvider(
    service = {
        EarModuleProviderImpl.class,
        EarProvider.class,
        J2eeModuleProvider.class,
        J2eeApplicationProvider.class
    },
    projectType = {
        "org-netbeans-modules-maven/" + NbMavenProject.TYPE_EAR
    }
)
public class EarModuleProviderImpl extends J2eeApplicationProvider implements EarProvider  {
    
    private EarImpl earimpl;
    private Project project;
    private String serverInstanceID;
    private J2eeModule j2eemodule;
    
    private final DeployOnSaveSupport deployOnSaveSupport = new DeployOnSaveSupportProxy();

    
    public EarModuleProviderImpl(Project proj) {
        project = proj;
        earimpl = new EarImpl(project, this);
    }
    
    public EarImplementation2 getEarImplementation() {
        return earimpl;
    }

    @Override
    public boolean isOnlyCompileOnSaveEnabled() {
        return RunUtils.isCompileOnSaveEnabled(project) && !MavenProjectSupport.isDeployOnSave(project);
    }
    
    @Override
    public Ear findEar(FileObject file) {
        Project proj = FileOwnerQuery.getOwner(file);
        if (proj != null) {
            proj = proj.getLookup().lookup(Project.class);
        }
        if (proj != null && project == proj) {
            if (earimpl != null && earimpl.isValid()) {
                return EjbJarFactory.createEar((EarImplementation2) earimpl);
            }
        }
        return null;
    }

    /**
     * Returns the provider for the child module specified by given URI.
     * 
     * @param uri the child module URI within the J2EE application.
     * @return J2eeModuleProvider object
     */
    @Override
    public J2eeModuleProvider getChildModuleProvider(String uri) {
//        System.out.println("!!!give me module with uri=" + uri);
        return null;
    }

    /**
     * Returns list of providers of every child J2EE module of this J2EE app.
     * 
     * @return array of J2eeModuleProvider objects.
     */
    @Override
    public J2eeModuleProvider[] getChildModuleProviders() {
        List<J2eeModuleProvider> provs = new ArrayList<J2eeModuleProvider>();
        for (Project prj : earimpl.getProjects()) {
            J2eeModuleProvider prv = prj.getLookup().lookup(J2eeModuleProvider.class);
            if (prv != null) {
                provs.add(prv);
            }
        }
        return provs.toArray(new J2eeModuleProvider[0]);
    }

    @Override
    public synchronized J2eeModule getJ2eeModule() {
        if (j2eemodule == null) {
            j2eemodule = J2eeModuleFactory.createJ2eeApplication(earimpl);
        }
        return j2eemodule; 
    }


    @Override
    public ModuleChangeReporter getModuleChangeReporter() {
        return earimpl;
    }

    public EarImpl getEarImpl() {
        return earimpl;
    }

    /**
     * Returns source deployment configuration file path for the given deployment 
     * configuration file name. 
     * 
     * @param name file name of the deployement configuration file.
     * @return non-null absolute path to the deployment configuration file.
     */
    public File getDeploymentConfigurationFile(String name) {
        if (name == null) {
            return null;
        }
        String path = getConfigSupport().getContentRelativePath(name);
        if (path == null) {
            path = name;
        }
//        System.out.println("EMPI: getDeploymentConfigFile=" + name);
        return earimpl.getDDFile(path);
    }



    /**
     * Finds source deployment configuration file object for the given deployment 
     * configuration file name.  
     * 
     * @param name file name of the deployement configuration file.
     * @return FileObject of the configuration descriptor file; null if the file does not exists.
     */
    public FileObject findDeploymentConfigurationFile(String name) {
        File fil = getDeploymentConfigurationFile(name);
        if (fil != null) {
            return FileUtil.toFileObject(fil);
        }
        return null;
    }

    @Override
    public void setServerInstanceID(String newID) {
       String oldID = null;
        if (serverInstanceID != null) {
            oldID = MavenProjectSupport.obtainServerID(serverInstanceID);
        }
        serverInstanceID = newID;
        fireServerChange(oldID, getServerID());  
    }
    
    @Override
    public String getServerInstanceID() {
        if (serverInstanceID != null && MavenProjectSupport.obtainServerID(serverInstanceID) != null) {
            return serverInstanceID;
        }
        return ExecutionChecker.DEV_NULL;
    }
    
    @Override
    public String getServerID() {
        if (serverInstanceID != null) {
            String serverID = MavenProjectSupport.obtainServerID(serverInstanceID);
            if (serverID != null) {
                return serverID;
            }
        }
        return ExecutionChecker.DEV_NULL;
    }
    
    
    @Override
    public FileObject[] getSourceRoots() {
       ProjectSourcesClassPathProvider cppImpl = project.getLookup().lookup(ProjectSourcesClassPathProvider.class);
        ClassPath cp = cppImpl.getProjectSourcesClassPath(ClassPath.SOURCE);
        NbMavenProject prj = project.getLookup().lookup(NbMavenProject.class);
        List<URL> resUris = new ArrayList<URL>();
        for (URI uri : prj.getResources(false)) {
            try {
                resUris.add(uri.toURL());
            } catch (MalformedURLException ex) {
//                Exceptions.printStackTrace(ex);
            }
        }
        Iterator<ClassPath.Entry> en = cp.entries().listIterator();
        List<FileObject> toRet = new ArrayList<FileObject>();
        int index = 0;
        while (en.hasNext()) {
            ClassPath.Entry ent = en.next();
            if (ent.getRoot() == null) continue;
            if (resUris.contains(ent.getURL())) {
                //put resources up front..
                toRet.add(index, ent.getRoot());
                index = index + 1;
            } else {
                toRet.add(ent.getRoot());
            }
        }
        return toRet.toArray(new FileObject[0]);
    }

    @Override
    public DeployOnSaveClassInterceptor getDeployOnSaveClassInterceptor() {
        return new DeployOnSaveClassInterceptor() {

            @Override
            public Artifact convert(Artifact original) {
                for (J2eeModuleProvider provider : getChildModuleProviders()) {
                    DeployOnSaveClassInterceptor interceptor = provider.getDeployOnSaveClassInterceptor();
                    if (interceptor != null) {
                        Artifact converted = interceptor.convert(original);
                        if (converted != original) {
                            return converted;
                        }
                    }
                }
                return original;
            }
        };
    }

    @Override
    public DeployOnSaveSupport getDeployOnSaveSupport() {
        return deployOnSaveSupport;
    }
    
    /**
     * This class is proxying events from child listeners.
     */
    private class DeployOnSaveSupportProxy implements ArtifactListener, DeployOnSaveSupport {

        private final List<ArtifactListener> listeners = new ArrayList<ArtifactListener>();

        public DeployOnSaveSupportProxy() {
            super();
        }

        @Override
        public synchronized void addArtifactListener(ArtifactListener listener) {
            //copyOnSaveSupport.addArtifactListener(listener);

            boolean register = listeners.isEmpty();
            if (listener != null) {
                listeners.add(listener);
            }

            if (register) {
                for (J2eeModuleProvider provider : getChildModuleProviders()) {
                    DeployOnSaveSupport support = provider.getDeployOnSaveSupport();
                    if (support != null) {
                        support.addArtifactListener(this);
                    }
                }
            }
        }

        @Override
        public synchronized void removeArtifactListener(ArtifactListener listener) {
            //copyOnSaveSupport.removeArtifactListener(listener);

            if (listener != null) {
                listeners.remove(listener);
            }

            if (listeners.isEmpty()) {
                for (J2eeModuleProvider provider : getChildModuleProviders()) {
                    DeployOnSaveSupport support = provider.getDeployOnSaveSupport();
                    if (support != null) {
                        support.removeArtifactListener(this);
                    }
                }
            }
        }

        @Override
        public boolean containsIdeArtifacts() {
            for (J2eeModuleProvider provider : getChildModuleProviders()) {
                DeployOnSaveSupport support = provider.getDeployOnSaveSupport();
                if (support != null) {
                    if (support.containsIdeArtifacts()) {
                        return true;
                    }
                }
            }
            return false;
        }

        
        @Override
        public void artifactsUpdated(Iterable<Artifact> artifacts) {
            List<ArtifactListener> toFire = null;
            synchronized (this) {
                toFire = new ArrayList<ArtifactListener>(listeners);
            }
            for (ArtifactListener listener : toFire) {
                listener.artifactsUpdated(artifacts);
            }
        }
    }    
}
