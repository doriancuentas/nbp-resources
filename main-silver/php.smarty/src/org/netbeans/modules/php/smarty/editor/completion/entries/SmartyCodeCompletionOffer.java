/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2010 Sun Microsystems, Inc. All rights reserved.
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
 * nbbuild/licenses/CDDL-GPL-2-CP.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the GPL Version 2 section of the License file that
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
 * Portions Copyrighted 2010 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.smarty.editor.completion.entries;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.netbeans.modules.php.smarty.editor.completion.TplCompletionItem;
import org.netbeans.modules.php.smarty.editor.completion.TplCompletionItem.BuiltInFunctionsCompletionItem;
import org.netbeans.modules.php.smarty.editor.completion.TplCompletionItem.CustomFunctionsCompletionItem;
import org.netbeans.modules.php.smarty.editor.completion.TplCompletionItem.VariableModifiersCompletionItem;
import org.openide.util.Exceptions;

/**
 *
 * @author Martin Fousek
 */
public class SmartyCodeCompletionOffer {

    private final static ArrayList<TplCompletionItem> completionItemsFunctions = new ArrayList<TplCompletionItem>();
    private final static ArrayList<TplCompletionItem> completionItemsModifiers = new ArrayList<TplCompletionItem>();
    private final static HashMap<String, ArrayList<TplCompletionItem>> completionItemsFunctionParams = new HashMap<String, ArrayList<TplCompletionItem>>();

    static {
        loadFunctions(new String[]{"built-in-functions", "custom-functions"});
        loadModifiers("variable-modifiers");
    }

    public static ArrayList<TplCompletionItem> getFunctions() {
        return completionItemsFunctions;
    }

    public static ArrayList<TplCompletionItem> getVariableModifiers() {
        return completionItemsModifiers;
    }

    public static HashMap<String, ArrayList<TplCompletionItem>> getFunctionParameters() {
        return completionItemsFunctionParams;
    }

    private static void loadFunctions(String[] types) {
        for (String completionType : types) {
            Collection<CodeCompletionEntryMetadata> ccList = parseCCData(completionType);
            if (completionType.equals("built-in-functions")) {
                for (CodeCompletionEntryMetadata entryMetadata : ccList) {
                    completionItemsFunctions.add(new BuiltInFunctionsCompletionItem(entryMetadata.getKeyword(), entryMetadata.getHelp(), entryMetadata.getHelpUrl()));
                    completionItemsFunctionParams.put(entryMetadata.getKeyword(), entryMetadata.getParameters());
                }
            } else if (completionType.equals("custom-functions")) {
                for (CodeCompletionEntryMetadata entryMetadata : ccList) {
                    completionItemsFunctions.add(new CustomFunctionsCompletionItem(entryMetadata.getKeyword(), entryMetadata.getHelp(), entryMetadata.getHelpUrl()));
                    completionItemsFunctionParams.put(entryMetadata.getKeyword(), entryMetadata.getParameters());
                }

            }
        }
    }

    private static void loadModifiers(String functionsFile) {
        Collection<CodeCompletionEntryMetadata> ccList = parseCCData(functionsFile);

        for (CodeCompletionEntryMetadata entryMetadata : ccList) {
            completionItemsModifiers.add(new VariableModifiersCompletionItem(entryMetadata.getKeyword(), entryMetadata.getHelp(), entryMetadata.getHelpUrl()));
        }
    }

    private static Collection<CodeCompletionEntryMetadata> parseCCData(String filePath) {
        Collection<CodeCompletionEntryMetadata> ccList = new ArrayList<CodeCompletionEntryMetadata>();
        InputStream inputStream = SmartyCodeCompletionOffer.class.getResourceAsStream("defs/" + filePath + ".xml"); //NOI18N

        try {
            Collection<CodeCompletionEntryMetadata> ccData = CodeCompletionEntries.readAllCodeCompletionEntriesFromXML(inputStream, filePath);
            ccList.addAll(ccData);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        return ccList;
    }
}
