/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html or
 * http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file and
 * include the License file at http://www.netbeans.org/cddl.txt. If applicable, add
 * the following below the CDDL Header, with the fields enclosed by brackets []
 * replaced by your own identifying information:
 *
 *     "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is NetBeans. The Initial Developer of the Original Software
 * is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun Microsystems, Inc. All
 * Rights Reserved.
 *
 * $Id$
 *
 */

package org.netbeans.test.installer;

import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.netbeans.junit.NbTestCase;
import org.netbeans.junit.NbTestSuite;

/**
 *
 * @author Mikhail Vaysman
 */
public class TestInstallerAndUninstallerJavaFX extends Installer {

    /*
    public TestInstallerAndUninstallerJavaFX() {
        super("Installer test");
    }

    public static Test suite() {
        TestSuite suite = new NbTestSuite(TestInstallerAndUninstallerJavaFX.class);

        return suite;
    }
    */

    public void testInstaller() {
        TestData data = new TestData(Logger.getLogger("global"));
        data.SetTestPackage( "java3/org-netbeans-modules-java-kit" ); // TODO

        Utils.phaseOne(data, "javafx");

        // Pages
        // Welcome
        Utils.stepWelcome();
        // Agreement
        Utils.stepLicense();
        // Location
        Utils.stepSetDir(
            data,
            "Install the NetBeans IDE",
            data.GetNetBeansInstallPath( )
          );
        // Summary
        Utils.stepInstall(data);
        //Installation
        //finish
        Utils.stepFinish();


        //Utils.phaseTwo(data);

        Utils.phaseFour(data);

        //Utils.RunCommitTests( data );

        Utils.phaseFive( data );

        //TODO Dir removed test
        //TODO Clean up work dir
    }

    //public static void main(String[] args) {
    //    junit.textui.TestRunner.run(suite());
    //}
}
