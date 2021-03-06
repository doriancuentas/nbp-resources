/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2008-2009 Sun Microsystems, Inc.
 */

package org.netbeans.modules.subversion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import org.netbeans.junit.MockServices;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.subversion.client.SvnClient;
import org.netbeans.modules.subversion.client.SvnClientExceptionHandler;
import org.netbeans.modules.subversion.client.SvnClientFactory;
import org.netbeans.modules.subversion.util.SvnUtils;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.netbeans.modules.versioning.util.FileUtils;
import org.netbeans.modules.subversion.utils.TestUtilities;
import org.netbeans.modules.versioning.util.Utils;
import org.tigris.subversion.svnclientadapter.ISVNClientAdapter;
import org.tigris.subversion.svnclientadapter.ISVNDirEntry;
import org.tigris.subversion.svnclientadapter.ISVNInfo;
import org.tigris.subversion.svnclientadapter.ISVNLogMessage;
import org.tigris.subversion.svnclientadapter.ISVNStatus;
import org.tigris.subversion.svnclientadapter.SVNClientException;
import org.tigris.subversion.svnclientadapter.SVNRevision;
import org.tigris.subversion.svnclientadapter.SVNStatusKind;
import org.tigris.subversion.svnclientadapter.SVNStatusUnversioned;
import org.tigris.subversion.svnclientadapter.SVNUrl;

/**
 *
 * @author Tomas Stupka
 */
public abstract class AbstractSvnTestCase extends NbTestCase {
   
    private File workDir;
    private FileStatusCache cache;
    private SVNUrl repoUrl;
    private File wc;
    private File repoDir;
    private String repoPath;
    protected static final String SUBVERSION_1_5 = "1.5";
    protected static final String SUBVERSION_1_6 = "1.6";
    protected static final String SUBVERSION_1_7 = "1.7";
    protected static final String SUBVERSION_1_8 = "1.8";
    private final static String JAVAHL = "javahl";
        
    public AbstractSvnTestCase(String testName) throws MalformedURLException, SVNClientException {
        super(testName);
        System.setProperty("work.dir", getWorkDirPath());
        workDir = new File(System.getProperty("work.dir")); 
        FileUtil.refreshFor(workDir);          
        repoDir = new File(getDataDir().getAbsolutePath() + "/repo");
        repoPath = repoDir.getAbsolutePath();
        if(repoPath.startsWith("/")) {
            //repoPath = repoPath.substring(1, repoPath.length());
        }
        
        wc = new File(workDir, getName() + "_wc");        
    }

    @Override
    protected void setUp() throws Exception {          
        super.setUp();      
        MockServices.setServices(new Class[] {
            SubversionVCS.class});
        repoUrl = new SVNUrl(TestUtilities.formatFileURL(new File(repoPath)));

        System.setProperty("netbeans.user", System.getProperty("work.dir") + "/cache");
        cache = Subversion.getInstance().getStatusCache();
        cache.cleanUp();
        
        cleanUpWC();  
        initRepo(repoDir);  
        
        wc.mkdirs();
        if(importOnSetup()) svnimportWC();
    }
    
    protected boolean importOnSetup() {
        if(getName().startsWith("testCheckout")) {
            return false;
        } 
        return true;
    }

    protected String getRepoURLProtocol() {
        return "file:///";
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        cleanUpWC();        
    }

    @Override
    protected Level logLevel() {
        return Level.FINE;
    }
        
    protected void commit(File folder, String msg) throws SVNClientException {
        commit(getFullWorkingClient(), folder, msg);
    }

    protected void commit(ISVNClientAdapter client, File folder, String msg) throws SVNClientException {
        add(client, folder);
        try {
            client.commit(new File[]{ folder }, msg, true);
        } catch (SVNClientException e) {
            if(e.getMessage().toLowerCase().indexOf("out of date") > -1) {
                try {
                    client.update(folder, SVNRevision.HEAD, true);
                    client.commit(new File[]{ folder }, msg, true);
                } catch (SVNClientException e1) {
                    fail("failed to commit file " + getFilePathDescr(folder) + ": " + e1.getMessage());
                }
            } else {
                fail("failed to commit file " + getFilePathDescr(folder) + ": " + e.getMessage());
            }            
        }    
        //assertStatus(SVNStatusKind.NORMAL, folder);
    }
    
    protected void commit(File folder) throws SVNClientException {
        commit(folder, "commit");
    }

    protected String getFilePathDescr(File file) {
        String relPath = getRelativePath(getWC(), file).getPath();
        return relPath.equals(".") ? "<workingcopy>"
                                   : "<workingcopy>/" + relPath;
    }

    protected static File getRelativePath(File upperFile, File lowerFile) {
        if (lowerFile.equals(upperFile)) {
            return new File(".");
        } else {
            return new File(upperFile.toURI().relativize(lowerFile.toURI()).getPath());
        }
    }

    protected void remove(File file) throws SVNClientException {        
        getFullWorkingClient().remove(new File[] {file}, true);
    }
    
    protected void copy(SVNUrl urlFrom, SVNUrl urlTo) throws SVNClientException {        
        getFullWorkingClient().copy(urlFrom, urlTo, "copy", SVNRevision.HEAD);
    }
    
    protected void ignore(File file) throws SVNClientException {        
        File parent =  file.getParentFile();
        List patterns = getFullWorkingClient().getIgnoredPatterns(parent);
        String path = file.getName();
        if(!patterns.contains(path)) {            
            patterns.add(path);
        }
        getFullWorkingClient().setIgnoredPatterns(parent, patterns);
        assertStatus(SVNStatusKind.IGNORED, file);
    }
    
    protected void add(File file) throws SVNClientException {
        add(getFullWorkingClient(), file);
    }

    protected void add(ISVNClientAdapter client, File file) throws SVNClientException {
        ISVNStatus status = getSVNStatus(file);        
        if(status.getTextStatus().equals(SVNStatusKind.UNVERSIONED)) {
            try {
                client.addFile(file);
            } catch (SVNClientException e) {
                if(e.getMessage().indexOf("is not a working copy") > -1 && 
                   containsParent(e.getMessage(), file.getParentFile())) 
                {
                    // ignore
                } else {
                    throw e;
                }
            }
        }
        if(file.isFile() || status.getTextStatus().equals(SVNStatusKind.IGNORED)) {
            return; 
        }
        File[] files = file.listFiles();
        if(files != null) {
            for (File f : files) {
                if(!isMetadata(f)) {
                    add(f);
                }
            }            
        }
    }
   
    protected void mkdir(SVNUrl url) throws SVNClientException {
        getFullWorkingClient().mkdir(url, "mkdir");
    }
   
    protected void setProperty(File file, String propName, String value) throws SVNClientException {
        getFullWorkingClient().propertySet(file, propName, value, false);
    }    
    
    protected void update(File file) throws SVNClientException {
        update(file, SVNRevision.HEAD);
    }
    
    protected void update(File file, SVNRevision rev) throws SVNClientException {
//        try {
//            String[] cmd = new String[]{"svn", "update", file.getAbsolutePath(), "--set-depth", "infinity"};
//            Process p = Runtime.getRuntime().exec(cmd);
//            p.waitFor();
//        } catch (IOException iOException) {
//            throw new SVNClientException(iOException);
//        } catch (InterruptedException interruptedException) {
//            throw new SVNClientException(interruptedException);
//        }
         getFullWorkingClient().update(file, rev, true);
    }    
    
    protected void cleanUpRepo() throws SVNClientException, IOException, InterruptedException {
        ISVNClientAdapter client = getFullWorkingClient();
        ISVNDirEntry[] entries = client.getList(repoUrl, SVNRevision.HEAD, false);
        SVNUrl[] urls = new SVNUrl[entries.length];
        for (int i = 0; i < entries.length; i++) {
            urls[i] = repoUrl.appendPath(entries[i].getPath());            
        }        
        cliRemove(urls);
    }
    
    protected void cleanUpRepo(String[] paths) throws SVNClientException, IOException, InterruptedException {
        ISVNClientAdapter client = getFullWorkingClient();
        SVNUrl[] urls = new SVNUrl[paths.length];
        for (int i = 0; i < paths.length; i++) {
            urls[i] = getTestUrl().appendPath(paths[i]);
        }
        try {
            cliRemove(urls);
        } catch (SVNClientException e) {
            if(e.getMessage().indexOf("does not exist") < 0) {
                throw e; 
            }
        }
    }

    private void cliRemove(SVNUrl... urls) throws SVNClientException, IOException, InterruptedException {
        for (SVNUrl url : urls) {
            String[] cmd = new String[] {"svn", "remove", url.toString(), "-m", "remove"};
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
        }
    }

    protected void cleanUpWC() throws IOException {
        if(wc.exists()) {
            File[] files = wc.listFiles();
            if(files != null) {
                for (File file : files) {
                    if(!file.getName().equals("cache")) { // do not delete the cache
                        if (file.exists()) {
                            Utils.deleteRecursively(file);
                        }
                    }                    
                }
            }
        }
    }

    protected void assertStatus(SVNStatusKind status, File file) throws SVNClientException {
        ISVNStatus[] values;
        try {
            values = getFullWorkingClient().getStatus(new File[]{file});
        } catch (SVNClientException ex) {
            if (SvnClientExceptionHandler.isUnversionedResource(ex.getMessage())) {
                values = new ISVNStatus[] { new SVNStatusUnversioned(file) };
            } else {
                throw ex;
            }
        }
        for (ISVNStatus iSVNStatus : values) {
            assertEquals(status, iSVNStatus.getTextStatus());
        }
    }
    
    protected void assertPropertyStatus(SVNStatusKind status, File file) throws SVNClientException {
        ISVNStatus[] values;
        try {
            values = getFullWorkingClient().getStatus(new File[]{file});
        } catch (SVNClientException ex) {
            if (SvnClientExceptionHandler.isUnversionedResource(ex.getMessage())) {
                values = new ISVNStatus[] { new SVNStatusUnversioned(file) };
            } else {
                throw ex;
            }
        }
        for (ISVNStatus iSVNStatus : values) {
            assertEquals(status, iSVNStatus.getPropStatus());
        }
    }
 
    protected ISVNStatus getSVNStatus(File file) throws SVNClientException {
        return SvnUtils.getSingleStatus(getFullWorkingClient(), file);
    }

    private boolean containsParent(String message, File parent) {
        while(parent != null) {
            if(message.indexOf(parent.getAbsolutePath()) > -1) {
                return true;
            }
            parent = parent.getParentFile();
        }
        return false;
    }

    protected SvnClient getFullWorkingClient() throws SVNClientException {
        return SvnClientFactory.getInstance().createSvnClient();
    }   
    
    protected void assertCachedStatus(File file, int expectedStatus) throws Exception {
        assert !file.isFile() || expectedStatus != FileInformation.STATUS_VERSIONED_UPTODATE : "doesn't work for dirs with FileInformation.STATUS_VERSIONED_UPTODATE. Use getStatus instead";
        int status = getCachedStatus(file, expectedStatus);
        assertEquals(expectedStatus, status);
    }        

    protected int getCachedStatus(File file, int exceptedStatus) throws Exception, InterruptedException {
        FileInformation info = null;
        for (int i = 0; i < 600; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                throw ex;
            }
            info = cache.getCachedStatus(file);
            if (info != null && info.getStatus() == exceptedStatus) {
                break;
            }            
        }
        if (info == null) {
            throw new Exception("Cache timeout!");
        }
        return info.getStatus();
    }
    
    protected int getStatus(File file) {
        return cache.refresh(file, FileStatusCache.REPOSITORY_STATUS_UNKNOWN).getStatus();
    }
    
    protected void initRepo(File repoDir) throws MalformedURLException, IOException, InterruptedException, SVNClientException {        
        if(!repoDir.exists()) {
            repoDir.mkdirs();            
            String[] cmd = new String[] {"svnadmin", "create", repoDir.getAbsolutePath()};
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();               
        }         
    }
    
    protected void svnimportWC() throws SVNClientException {
        ISVNClientAdapter client = getFullWorkingClient();
        SVNUrl url = getTestUrl().appendPath(wc.getName());
        try {
            client.mkdir(url, true, "msg");
        } catch (SVNClientException ex) {
        }
        client.checkout(url, wc, SVNRevision.HEAD, true);        
        File[] files = wc.listFiles();
        if(files != null) {
            for (File file : files) {
                if(!isMetadata(file)) {
                    client.addFile(file);
                }
            }
            client.commit(new File[] {wc}, "commit", true);                    
        }        
    }        
    
    protected void importFile(File folder) throws SVNClientException {
        ISVNClientAdapter client = getFullWorkingClient();
        SVNUrl url = getTestUrl().appendPath(folder.getName());        
        client.mkdir(url, true, "msg");
        client.checkout(url, folder, SVNRevision.HEAD, true);        
        File[] files = folder.listFiles();
        if(files != null) {
            for (File file : files) {
                if(!isMetadata(file)) {
                    if (file.isDirectory()) {
                        client.addDirectory(file, true);
                    } else {
                        client.addFile(file);
                    }
                }
            }
            client.commit(new File[] {folder}, "commit", true);                    
        }        
    }        
        
    protected void addFile(File fromFile) {
        addFile(fromFile);
    }
        
    protected void delete(File file) throws IOException {
        DataObject dao = DataObject.find(FileUtil.toFileObject(file));    
        dao.delete();   
    }   
    
    protected SVNRevision getRevision(File file) throws SVNClientException {
        return getInfo(file).getRevision();
    }
    
    protected SVNRevision getRevision(SVNUrl url) throws SVNClientException {
        return getInfo(url).getRevision();
    }
    
    protected ISVNInfo getInfo(SVNUrl url) throws SVNClientException {
        return getFullWorkingClient().getInfo(url);
    }
    
    protected ISVNLogMessage[] getCompleteLog(SVNUrl url) throws SVNClientException {
        return getFullWorkingClient().getLogMessages(url, SVNRevision.HEAD, new SVNRevision.Number(0), SVNRevision.HEAD, true, false, 0L);
    }
    
    protected ISVNLogMessage[] getLog(SVNUrl url) throws SVNClientException {
        return getFullWorkingClient().getLogMessages(url, SVNRevision.HEAD, SVNRevision.HEAD);
    }
    
    protected InputStream getContent(SVNUrl url) throws SVNClientException {
        return getFullWorkingClient().getContent(url, SVNRevision.HEAD);
    }
    
    protected ISVNInfo getInfo(File file) throws SVNClientException {
        return getFullWorkingClient().getInfoFromWorkingCopy(file);
    }
    
    protected void copy(File file, File copy) throws SVNClientException {
        getFullWorkingClient().copy(file, copy);
    }

    protected void copy(File file, SVNUrl url) throws SVNClientException {
        getFullWorkingClient().copy(new File[] {file}, url, "copy", true, true);
    }
    
    protected ISVNDirEntry[] list(SVNUrl url) throws SVNClientException {
        return getFullWorkingClient().getList(url, SVNRevision.HEAD, false);
    }
    
    protected void unlock(File file, String msg, boolean force) throws SVNClientException {
        try {
            getFullWorkingClient().unlock(new File[]{file}, force);
        } catch (SVNClientException e) {
            if(e.getMessage().indexOf("No lock on path") < 0) {
                throw e;
            }
        }
    }
    
    protected void lock(File file, String msg, boolean force) throws SVNClientException {
        unlock(file, "unlock", force);
        getFullWorkingClient().lock(new File[] {file}, msg, force);
    }
    
    protected void waitALittleBit(long t) {
        try {
            Thread.sleep(t);  
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    protected File getWC() {
        return wc;
    }

    protected SVNUrl getRepoUrl() {
        return repoUrl;
    }
    
    protected SVNUrl copyRepo() throws MalformedURLException {
        String repopath = repoDir.getParent() + "/repo2";
        File repo2Dir = new File(repopath);
        FileUtils.copyDirFiles(getRepoDir(), repo2Dir);
        return new SVNUrl(TestUtilities.formatFileURL(new File(repopath)));
    }
    
    protected File getRepoDir() {
        return repoDir;
    }

    protected boolean isMetadata(File file) {
        return SvnUtils.isAdministrative(file) || SvnUtils.isPartOfSubversionMetadata(file);
    }

    protected SVNUrl getTestUrl() {
        return repoUrl.appendPath(getName());
    }

    protected SVNUrl getFileUrl(File file) {
        if (file.isAbsolute()) {
            return getFileUrl(getPathRelativeToWC(file));
        } else {
            return getFileUrl(file.getPath());
        }
    }

    protected SVNUrl getFileUrl(String relativePath) {
        checkIsRelativePath(relativePath);
        return getTestUrl().appendPath(getWC().getName()).appendPath(relativePath);
    }

    protected String getPathRelativeToWC(File file) {
        URI wcURI = getWC().toURI();
        URI fileURI = file.toURI();
        URI relativePathURI = wcURI.relativize(fileURI);
        if (relativePathURI == fileURI) {
            throw new IllegalArgumentException(
                    "The given file is not in the working directory.");
        }
        return relativePathURI.getPath();
    }

    protected void checkIsRelativePath(String path) {
        checkIsRelativePath(new File(path));
    }

    protected void checkIsRelativePath(File file) {
        if (file.isAbsolute()) {
            throw new IllegalArgumentException(
                    "Only relative path is legal, but an absolute path was passed ("
                    + file.getPath() + ')');
        }
    }

    protected boolean isJavahl () {
        return SvnClientFactory.isJavaHl();
    }

    protected boolean isSvnkit () {
        return SvnClientFactory.isSvnKit();
    }

    protected boolean isCommandLine () {
        return SvnClientFactory.isCLI();
    }
}
