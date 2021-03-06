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
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
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
 */

package org.netbeans.modules.editor.lib2.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Cache containing paragraph-view references of lines where text layouts
 * are actively held or where children are actively maintained.
 * <br/>
 * This class is not multi-thread safe.
 * 
 * @author Miloslav Metelka
 */

public final class TextLayoutCache {

    // -J-Dorg.netbeans.modules.editor.lib2.view.TextLayoutCache.level=FINE
    private static final Logger LOG = Logger.getLogger(TextLayoutCache.class.getName());

    /**
     * Cache text layouts and pView children for the following number of paragraph views.
     * These should be both visible lines and possibly lines where model-to-view
     * translations are being done.
     */
    private static final int DEFAULT_CAPACITY = 300;

    private final Map<ParagraphView, Entry> paragraph2entry = new HashMap<ParagraphView, Entry>();

    /**
     * Most recently used entry.
     */
    private Entry head;

    /**
     * Least recently used entry.
     */
    private Entry tail;
    
    private int capacity = DEFAULT_CAPACITY;

    public TextLayoutCache() {
    }

    /**
     * Clear the whole cache in case of global changes (e.g. font-render-context etc.)
     * when all children are released (no release of individual entries performed). 
     *
     */
    void clear() {
        paragraph2entry.clear();
        head = tail = null;
    }
    
    int size() {
        return paragraph2entry.size();
    }
    
    int capacity() {
        return capacity;
    }
    
    /**
     * Possibly increase the capacity against default size.
     * When shrinking the cache exceeding items are dropped.
     *
     * @param capacity 
     */
    void setCapacityOrDefault(int capacity) {
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        for (int i = size() - this.capacity; i >= 0; i--) {
            removeTailEntry();
        }
    }

    boolean contains(ParagraphView paragraphView) {
        assert (paragraphView != null);
        Entry entry = paragraph2entry.get(paragraphView);
        return (entry != null);
    }

    /**
     * Move the cache entry for the given paragraphView to the beginning of cache
     * (possibly adding it to the cache if not present).
     *
     * @param paragraphView non-null paragraph view.
     */
    void activate(ParagraphView paragraphView) {
        assert (paragraphView != null);
//        DocumentView docView = paragraphView.getDocumentView();
//        docView.checkDocumentLockedIfLogging();
//        docView.checkMutexAcquiredIfLogging();
        Entry entry = paragraph2entry.get(paragraphView);
        if (entry == null) {
            entry = new Entry(paragraphView);
            paragraph2entry.put(paragraphView, entry);
            if (paragraph2entry.size() > capacity) { // Cache full => remove LRU
                removeTailEntry();
            }
            addChainEntryFirst(entry);
        }
        if (head != entry) { // Possibly move entry to head
            removeChainEntry(entry); // Do not release text layouts
            addChainEntryFirst(entry);
        }
    }
    
    private void removeTailEntry() {
        Entry tailEntry = paragraph2entry.remove(tail.paragraphView);
        assert (tailEntry == tail);
        removeChainEntry(tailEntry);
        tailEntry.release();
    }

    /**
     * Replace paragraph view in an existing entry without activating the entry.
     *
     * @param origPView original view to be abandoned.
     * @param newPView new view to be used.
     */
    void replace(ParagraphView origPView, ParagraphView newPView) {
        assert (origPView != null);
        Entry entry = paragraph2entry.get(origPView);
        if (entry == null) {
            throw new IllegalStateException("origPView=" + origPView + " not cached!"); // NOI18N
        }
        entry.paragraphView = newPView;
        paragraph2entry.put(newPView, entry);
    }

    void remove(ParagraphView paragraphView, boolean clearTextLayouts) {
        Entry entry = paragraph2entry.remove(paragraphView);
        if (entry != null) {
            removeChainEntry(entry);
            if (clearTextLayouts) {
                entry.release();
            }
        }
    }
    
    String findIntegrityError() {
        Entry entry = head;
        if (head != null) {
            if (tail == null) {
                return "Null tail but non-null head"; // NOI18N
            }
        } else {
            if (tail != null) {
                return "Null head but non-null tail"; // NOI18N
            }
        }
        Entry lastEntry = entry;
        HashSet<Entry> entriesCopy = new HashSet<Entry>(paragraph2entry.values());
        while (entry != null) {
            ParagraphView pView = entry.paragraphView;
            if (!entriesCopy.remove(entry)) {
                return "TextLayoutCache: Chain entry not contained (or double contained) in map: " + // NOI18N 
                        pView + ", parent=" + pView.getParent(); // NOI18N
            }
            if (pView.getParent() == null) {
                return "TextLayoutCache: Null parent for " + pView; // NOI18N
            }
            lastEntry = entry;
            entry = entry.next;
        }
        if (lastEntry != tail) {
            return "lastEntry=" + Entry.toString(lastEntry) + " != tail=" + Entry.toString(tail); // NOI18N
        }
        if (0 != entriesCopy.size()) {
            return "TextLayoutCache: unchained entryCount=" + entriesCopy.size(); // NOI18N
        }
        return null;
    }

    private void addChainEntryFirst(Entry entry) {
        assert (entry.previous == null && entry.next == null);
        if (head == null) {
            assert (tail == null);
            head = tail = entry;
            // Leave entry.previous == entry.next == null;
        } else {
            assert (tail != null);
            entry.next = head;
            head.previous = entry;
            head = entry;
        }
    }

    private void removeChainEntry(Entry entry) {
        if (entry != head) {
            entry.previous.next = entry.next;
        } else { // First entry
            assert (entry.previous == null);
            head = entry.next;
        }
        if (entry != tail) {
            entry.next.previous = entry.previous;
        } else { // Last entry
            assert (entry.next == null);
            tail = entry.previous;
        }
        entry.previous = entry.next = null;
    }

    @Override
    public String toString() {
        return "size=" + size() + ", capacity=" + capacity + ", head=" + head + ", tail=" + tail; // NOI18N
    }

    private static final class Entry {

        ParagraphView paragraphView;

        Entry previous;

        Entry next;

        Entry(ParagraphView paragraphView) {
            this.paragraphView = paragraphView;
        }

        void release() {
            paragraphView.releaseTextLayouts();
        }

        @Override
        public String toString() {
            return "Entry[pView=" + paragraphView + "\n" + "previous=" + // NOI18N
                    toString(previous) + ", next=" + toString(next) + "]"; // NOI18N
        }
        
        public String toStringShort() {
            return "Entry@" + System.identityHashCode(this);
        }
        
        private static String toString(Entry entry) {
            return (entry != null) ? entry.toStringShort() : "null";
        }
        
    }

}
