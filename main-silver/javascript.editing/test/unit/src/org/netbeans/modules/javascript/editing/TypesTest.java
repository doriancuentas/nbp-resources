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
 * Portions Copyrighted 2008 Sun Microsystems, Inc.
 */

package org.netbeans.modules.javascript.editing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mozilla.nb.javascript.Node;
import org.mozilla.nb.javascript.Token;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.Parser;
import org.openide.filesystems.FileObject;

/**
 * Check the type inference for various files. Generates *.types goldenfiles.
 *
 * @author Tor Norbye
 */
public class TypesTest extends JsTestBase {

    public TypesTest(String testName) {
        super(testName);
    }

    @Override
    protected void initializeTypeNodes(ParserResult info, List<Object> nodes,
            Map<Object,OffsetRange> positions, Map<Object,String> types) throws Exception {

        Node root = ((JsParseResult) info).getRootNode();
        assertNotNull(root);

        initialize(root, nodes, types, positions, (JsParseResult) info);
    }

    private void initialize(Node node, List<Object> nodes, Map<Object,String> types, Map<Object,
            OffsetRange> positions, JsParseResult info) throws Exception {
        if (node.getSourceStart() > node.getSourceEnd()) {
            BaseDocument doc = (BaseDocument) info.getSnapshot().getSource().getDocument(true);
            assertTrue(node.toString() + "; node=" + node.toString() + " at line " + org.netbeans.editor.Utilities.getLineOffset(doc, node.getSourceStart()), false);
        }
        OffsetRange range = new OffsetRange(node.getSourceStart(), node.getSourceEnd());
        if (range.getStart() != 0 || range.getEnd() != 0) { // Don't include 0-0 nodes, these are errors
            String type = null;
            if (node.getType() == Token.CALL) {
                Node callNode = node;
                type = JsTypeAnalyzer.getCallFqn(info, callNode, true);
            }
            if (type == null) {
// XXX: parsingapi
//                JsIndex index = JsIndex.get(info.getIndex(JsTokenId.JAVASCRIPT_MIME_TYPE));
//                Node methodNode = node.getParentNode();
//                while (methodNode != null) {
//                    if (methodNode.getType() == Token.FUNCTION) {
//                        break;
//                    }
//                    methodNode = methodNode.getParentNode();
//                }
//                if (methodNode == null) {
//                    methodNode = info.getRootNode();
//                }
//                // No index - because we don't want to look up local symbols as though they are global
//                JsTypeAnalyzer analyzer = new JsTypeAnalyzer(info, index, methodNode, node, 0, 0);
//                type = analyzer.getType(node);

//                if (type == null && (node.getType() == Token.NAME || node.getType() == Token.BINDNAME)) {
//                    // See if it's a global variable
//                    if (AstUtilities.isGlobalVar(info, node)) {
//                        type = analyzer.getType(node.getString());
//                    }
//                }

// XXX: parsingapi
//                if (type == null && AstUtilities.isNameNode(node)) {
//                    type = analyzer.getType(node.getString());
//                }
            }

            if (type != null) {
                types.put(node, type);
                nodes.add(node);
                positions.put(node, range);
            }
        } else {
            // No position information... not sure what to do about these...
        }

        if (node.hasChildren()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNext()) {
                assert child != null;
                initialize(child, nodes, types, positions, info);
            }
        }
    }

//    public void testTypes1() throws Exception {
//        checkTypes("testfiles/simple.js");
//    }
//
//    public void testTypes2() throws Exception {
//        checkTypes("testfiles/prototype.js");
//    }
//
//    public void testTypes3() throws Exception {
//        checkTypes("testfiles/types1.js");
//    }
//
//    public void testTypes4() throws Exception {
//        checkTypes("testfiles/types2.js");
//    }
//
//    public void testTypes5() throws Exception {
//        checkTypes("testfiles/orig-dojo.js.uncompressed.js");
//    }
//
//    public void testTypes6() throws Exception {
//        checkTypes("testfiles/woodstock-body.js");
//    }
//
//    public void testTypes7() throws Exception {
//        checkTypes("testfiles/SpryEffects.js");
//    }
//
//    public void testTypes8() throws Exception {
//        checkTypes("testfiles/SpryData.js");
//    }
//
//    public void testTypes9() throws Exception {
//        checkTypes("testfiles/jmaki-uncompressed.js");
//    }

    // Make sure we don't bomb out analyzing any of these files
    // Compute types for lots of files - but don't store the results,
    // just make sure we don't abort during scanning.
    public void testStress() throws Exception {
        for (String file : JAVASCRIPT_TEST_FILES) {
            FileObject f = getTestFile(file);
            Source source = Source.create(f);

            ParserManager.parse(Collections.singleton(source), new UserTask() {
                public @Override void run(ResultIterator resultIterator) throws Exception {
                    Parser.Result r = resultIterator.getParserResult();
                    JsParseResult jspr = AstUtilities.getParseResult(r);
                    assertNotNull("Expecting JsParseResult, but got " + r, jspr);

                    List<Object> nodes = new ArrayList<Object>();
                    Map<Object,String> types = new HashMap<Object,String>();
                    Map<Object,OffsetRange> positions = new HashMap<Object,OffsetRange>();
                    initializeTypeNodes(jspr, nodes, positions, types);
                }
            });
        }
    }
}
