/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2014 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2014 Sun Microsystems, Inc.
 */

package org.netbeans.modules.java.source.parsing;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;
import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.api.annotations.common.NullAllowed;
import org.netbeans.api.java.lexer.JavaTokenId;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.queries.FileEncodingQuery;
import org.netbeans.modules.java.preprocessorbridge.spi.JavaFileFilterImplementation;
import org.netbeans.modules.parsing.api.Source;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.filesystems.FileUtil;
import org.openide.filesystems.JarFileSystem;
import org.openide.util.Lookup;
import org.openide.util.Parameters;
import org.openide.util.BaseUtilities;

/**
 *
 * @author Tomas Zezula
 */
//@NotThreadSafe
public abstract class AbstractSourceFileObject implements PrefetchableJavaFileObject {

    private static final Logger LOG = Logger.getLogger(AbstractSourceFileObject.class.getName());
    //@GuardedBy("AbstractSourceFileObject.class")
    private static SourceFileObjectProvider factory;

    private final Handle handle;
    private final JavaFileFilterImplementation filter;
    private final JavaFileObject.Kind kind;

    private String text;
    private TokenHierarchy<?> tokens;
    private URI uri;        //Cache for URI

    protected AbstractSourceFileObject (
            @NonNull final Handle handle,
            @NullAllowed final JavaFileFilterImplementation filter) {
        Parameters.notNull("handle", handle);   //NOI18N
        this.handle = handle;
        this.filter = filter;
        final String ext = this.handle.getExt();
        this.kind = filter == null ?
            FileObjects.getKind(ext) :
            Kind.SOURCE; //#141411
    }
    
    //JavaFileObject methods

    @Override
    @NonNull
    public final JavaFileObject.Kind getKind() {
        return this.kind;
    }

    @Override
    @NonNull
    public final String getName() {
       return this.handle.getName(true);
    }

    @Override
    @CheckForNull
    public final NestingKind getNestingKind() {
        return null;
    }

    @Override
    @CheckForNull
    public final Modifier getAccessLevel() {
        return null;
    }

    @Override
    public final boolean isNameCompatible (
            @NonNull final String simplename,
            @NonNull final JavaFileObject.Kind kind) {
        assert simplename != null;
        return this.kind == kind && this.getNameWithoutExtension().equals(simplename);
    }

    @Override
    @NonNull
    public final CharBuffer getCharContent(final boolean ignoreEncodingErrors) throws IOException {
        String _text = this.text;
        if (_text == null) {
            _text = getContent(false);
        }
        return CharBuffer.wrap(_text);
    }

    @Override
    @NonNull
    public final Writer openWriter() throws IOException {
        final FileObject file = handle.resolveFileObject(true);
        if (file == null) {
            throw new IOException("Cannot create file: " + toString());   //NOI18N
        }
        return new OutputStreamWriter (
            this.openOutputStream(),
            FileEncodingQuery.getEncoding(file));
    }

    @Override
    @NonNull
    public final Reader openReader(final boolean ignoreEncodingErrors) throws IOException {
        String _text = text;
        if (_text == null) {
            _text = getContent(false);
        }
        return new StringReader(_text);
    }

    @Override
    @NonNull
    public final OutputStream openOutputStream() throws IOException {
        final FileObject file = handle.resolveFileObject(true);
        if (file == null) {
            throw new IOException("Cannot create file: " + toString());   //NOI18N
        }
        OutputStream res = createOutputStream();
        if (res == null) {
            res = new LckStream (file);
        }
        return res;
    }

    @Override
    @NonNull
    public final InputStream openInputStream() throws IOException {
        String _text = text;
        if (_text == null) {
            _text= getContent(false);
        }
        return new ByteArrayInputStream (_text.getBytes());
    }

    /**
     * Returns the mtime of the file, in the case of opened
     * modified file, the mtime is not known, this method returns
     * the current time.
     */
    @Override
    public long getLastModified() {
        Long dirty;
        if (isModifiedByWorkingCopy()) {
            return System.currentTimeMillis();
        } else if ((dirty = isDirty()) != null) {
            return dirty;
        } else {
            return getFileLastModified();
        }
    }

    @Override
    public final URI toUri () {
        if (this.uri == null) {
            try {
                this.uri = URI.create(this.handle.getURL().toExternalForm());
            } catch (IOException e) {
                LOG.log(
                    Level.SEVERE,
                    e.getMessage(),
                    e);
            }
        }
        return this.uri;
    }

    @Override
    public final boolean delete() {
        if (isDirty() != null) {
            //If the file is modified in editor do not delete it
            return false;
        } else {
            final FileObject file = handle.resolveFileObject(false);
            if (file == null) {
                return false;
            }
            try {
                FileLock lock = file.lock();
                try {
                    file.delete (lock);
                    return true;
                }
                finally {
                    lock.releaseLock();
                }
            } catch (IOException e) {
                return false;
            }
        }
    }

    //InferableJavaFileObject methods
    @Override
    @CheckForNull
    public final String inferBinaryName () {
        if (handle.root == null) {
            return null;
        }
        final String relativePath = handle.getRelativePath();
        assert relativePath != null : "root=" + FileUtil.getFileDisplayName(handle.root) + ", file=" + toString();
        final int index = relativePath.lastIndexOf('.');
        assert index > 0;
        final String result = relativePath.substring(0,index).replace('/','.');
        return result;
    }

    //PrefetchableJavaFileObject methods
    @Override
    public final int prefetch() throws IOException {
        return 0;
    }

    @Override
    public final int dispose() {
        return 0;
    }

    //j.l.Object methods
    @Override
    @NonNull
    public final String toString () {
        final URI uri = toUri();
        try {
            final File file = BaseUtilities.toFile(uri);
            return file.getAbsolutePath();
        } catch (IllegalArgumentException iae) {
            return uri.toString();
        }
    }

    @Override
    public final boolean equals (@NullAllowed final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AbstractSourceFileObject)) {
            return false;
        }
        final AbstractSourceFileObject otherSource = (AbstractSourceFileObject) other;
        return this.handle.equals (otherSource.handle);
    }

    @Override
    public final int hashCode () {
        return this.handle.hashCode();
    }

    //AbstractSourceFileObject public methods

    @NonNull
    public final String getNameWithoutExtension() {
        return this.handle.getName(false);
    }

    @NonNull
    public final TokenHierarchy<?> getTokenHierarchy() throws IOException {
        if (this.tokens == null) {
            final CharBuffer charBuffer = getCharContent(true);
            this.tokens = TokenHierarchy.create(charBuffer, false, JavaTokenId.language(), null, null); //TODO: .createSnapshot();
        }
        return this.tokens;
    }

    public final void update () throws IOException {
        if (this.kind != Kind.CLASS) {
            //Side effect assigns the text
            getContent(true);
        }
    }

    public final void update (CharSequence content) throws IOException {
        if (content == null) {
            update();
        } else {
            if (filter != null) {
                final FileObject file = handle.resolveFileObject(false);
                if (file != null) {
                    final Source source = Source.create(file);
                    if (source != null && source.getDocument(false) == null) {
                        content = filter.filterCharSequence(content);
                    }
                }
            }
            this.text = toString(content);
        }
        this.tokens = null;
    }

    @NonNull
    protected final Handle getHandle() {
        return this.handle;
    }

    protected final void resetCaches() {
        this.text = null;
    }

    @NonNull
    protected final CharSequence filter(@NonNull final CharSequence text) {
        return filter != null ?
            filter.filterCharSequence(text) :
            text;
    }

    //AbstractSourceFileObject SPI methods

    protected abstract Long isDirty();

    @CheckForNull
    protected abstract OutputStream createOutputStream() throws IOException ;

    @NonNull
    protected abstract CharSequence createContent() throws IOException;

    //Private methods

    @NonNull
    private String getContent(final boolean assign) throws IOException {
        final CharSequence content = createContent();
        final String result = toString(content);
        if (assign) {
            this.text = result;
        }
        return result;
    }

    @NonNull
    private static String toString (@NonNull final CharSequence c) {
        if (c instanceof String) {
            return (String) c;
        } else {
            return c.toString();
        }
    }

    private boolean isModifiedByWorkingCopy() {
        final FileObject file = handle.resolveFileObject(false);
        if (file == null) {
            return false;
        }
        return SourceFileManager.getModifiedFiles().isModified(file.toURI());
    }

    private long getFileLastModified() {
        final FileObject file = handle.resolveFileObject(false);
        try {
            //Prefer class files to packed sources, the packed sources may have wrong time stamps.
            if (file == null || file.getFileSystem() instanceof JarFileSystem) {
                return 0L;
            }
        } catch (FileStateInvalidException e) {
            //Handled below
        }
        return file.lastModified().getTime();
    }

    //Static methods
    @NonNull
    public static synchronized SourceFileObjectProvider getFactory() {
        if (factory == null) {
            factory = Lookup.getDefault().lookup(SourceFileObjectProvider.class);
            if (factory == null) {
                factory = new DefaultSourceFileObjectProvider();
            }
        }
        return factory;
    }


    //@NotThreadSafe
    public static class Handle {

        protected final FileObject root;
        protected FileObject file;

        protected Handle(final FileObject root) {
            this.root = root;
        }

        public Handle(final FileObject file, final FileObject root) {
            assert file != null;
            this.file = file;
            this.root = root;
        }

        public FileObject resolveFileObject (boolean write) {
            return file;
        }

        public URL getURL() throws IOException {
            return file == null ? null : file.toURL();
        }

        public String getExt() {
            return file == null ? null : file.getExt();
        }

        public String getName(boolean includeExtension) {
            return file == null ? null : includeExtension ? file.getNameExt() : file.getName();
        }

        public String getRelativePath() {
            if (file == null) {
                return null;
            }
            final String result = FileUtil.getRelativePath(root,file);
            assert result != null : String.format("root=%s(%b,%b) file=%s(%b)",
                    FileUtil.getFileDisplayName(root),
                    root.isValid(),
                    root.isFolder(),
                    FileUtil.getFileDisplayName(file),
                    file.isValid()
                    );
            return result;
        }

        @Override
        public int hashCode() {
            return file == null ? 0 : file.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Handle other = (Handle) obj;
            return this.file == null ? other.file == null : this.file.equals(other.file);
        }
    }

    private class LckStream extends OutputStream {

        private final OutputStream delegate;
        private final FileLock lock;

        public LckStream (final FileObject fo) throws IOException {
            assert fo != null;
            this.lock = fo.lock();
            OutputStream d = null;
            try {
                d = fo.getOutputStream (this.lock);
                this.delegate = d;
            } finally {
                if (d == null) {
                    this.lock.releaseLock();
                }
            }
        }

        public @Override void write(byte[] b, int off, int len) throws IOException {
            this.delegate.write(b, off, len);
        }

        public @Override void write(byte[] b) throws IOException {
            this.delegate.write(b);
        }

        @Override
        public void write(int b) throws IOException {
            this.delegate.write (b);
        }

        public @Override void close() throws IOException {
            try {
                this.delegate.close();
            } finally {
                this.lock.releaseLock();
                resetCaches();
            }
        }
    }
}
