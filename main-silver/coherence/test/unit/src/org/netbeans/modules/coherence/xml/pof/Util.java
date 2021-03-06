/*
 * Util.java
 *
 * Created on October 4, 2005, 7:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.netbeans.modules.coherence.xml.pof;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import javax.swing.text.Document;

import org.netbeans.modules.xml.xam.ModelSource;
import org.netbeans.modules.xml.xam.dom.AbstractDocumentModel;
import org.netbeans.modules.xml.xam.dom.DocumentModel;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author nn136682
 */
public class Util {

    static {
        //JEditorPane.registerEditorKitForContentType(SchemaDataLoader.MIME_TYPE, XMLKit.class.getName());
        registerXMLKit();
    }

    public static void registerXMLKit() {
        String[] path = new String[]{"Editors", "text", "x-xml"};
        FileObject target = FileUtil.getConfigRoot();
        try {
            for (int i = 0; i < path.length; i++) {
                FileObject f = target.getFileObject(path[i]);
                if (f == null) {
                    f = target.createFolder(path[i]);
                }
                target = f;
            }
            String name = "EditorKit.instance";
            if (target.getFileObject(name) == null) {
                FileObject f = target.createData(name);
                f.setAttribute("instanceClass", "org.netbeans.modules.xml.text.syntax.XMLKit");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Document getResourceAsDocument(String path) throws Exception {
        InputStream in = Util.class.getResourceAsStream(path);
        return loadDocument(in);
    }

    public static Document loadDocument(InputStream in) throws Exception {
//	Document sd = new PlainDocument();
//        Document sd = new org.netbeans.editor.BaseDocument(
//                org.netbeans.modules.xml.text.syntax.XMLKit.class, false);

        // TODO: Check this is correct
        Document sd = new org.netbeans.editor.BaseDocument(false, TestCatalogModel.XML_MIME_TYPE);

        return setDocumentContentTo(sd, in);
    }

    public static Document setDocumentContentTo(Document doc, InputStream in) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuffer sbuf = new StringBuffer();
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                sbuf.append(line);
                sbuf.append(System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }
        doc.remove(0, doc.getLength());
        doc.insertString(0, sbuf.toString(), null);
        return doc;
    }

    public static Document setDocumentContentTo(Document doc, String resourcePath) throws Exception {
        return setDocumentContentTo(doc, Util.class.getResourceAsStream(resourcePath));
    }

    public static void setDocumentContentTo(DocumentModel model, String resourcePath) throws Exception {
        setDocumentContentTo(((AbstractDocumentModel) model).getBaseDocument(), resourcePath);
        model.sync();
    }
    public static int count = 0;

    public static PofConfigModel loadRegistryModel(String resourcePath) throws Exception {
        URI locationURI = new URI(resourcePath);
//        System.out.println("resourcePath = " + resourcePath);
//        System.out.println("locationURI = " + locationURI);
//        System.out.println("TestCatalogModel.getDefault() = " + TestCatalogModel.getDefault());
        TestCatalogModel.getDefault().addURI(locationURI, getResourceURI(resourcePath));
        ModelSource ms = TestCatalogModel.getDefault().getModelSource(locationURI);
        return PofConfigModelFactory.getInstance().getModel(ms);
    }

    public static PofConfigModel loadRegistryModel(File schemaFile) throws Exception {
        URI locationURI = new URI(schemaFile.getName());
        TestCatalogModel.getDefault().addURI(locationURI, schemaFile.toURI());
        ModelSource ms = TestCatalogModel.getDefault().getModelSource(locationURI);
        return PofConfigModelFactory.getInstance().getModel(ms);
    }

    public static void dumpToStream(Document doc, OutputStream out) throws Exception {
        PrintWriter w = new PrintWriter(out);
        w.print(doc.getText(0, doc.getLength()));
        w.close();
        out.close();
    }

    public static void dumpToFile(DocumentModel model, File f) throws Exception {
        dumpToFile(((AbstractDocumentModel) model).getBaseDocument(), f);
    }

    public static void dumpToFile(Document doc, File f) throws Exception {
        OutputStream out = new BufferedOutputStream(new FileOutputStream(f));
        PrintWriter w = new PrintWriter(out);
        w.print(doc.getText(0, doc.getLength()));
        w.close();
        out.close();
    }

    public static PofConfigModel dumpAndReloadModel(PofConfigModel sm) throws Exception {
        return dumpAndReloadModel((Document) sm.getModelSource().getLookup().lookup(Document.class));
    }

    public static File dumpToTempFile(Document doc) throws Exception {
        File f = File.createTempFile("faces-config-tmp", "xml");
//        System.out.println("file: " + f.getAbsolutePath());
        dumpToFile(doc, f);
        return f;
    }

    public static PofConfigModel dumpAndReloadModel(Document doc) throws Exception {
        File f = dumpToTempFile(doc);
        URI dumpURI = new URI("dummyDump" + count++);
        TestCatalogModel.getDefault().addURI(dumpURI, f.toURI());
        ModelSource ms = TestCatalogModel.getDefault().getModelSource(dumpURI);
        return PofConfigModelFactory.getInstance().getModel(ms);
    }

    public static Document loadDocument(File f) throws Exception {
        InputStream in = new BufferedInputStream(new FileInputStream(f));
        return loadDocument(in);
    }

    public static URI getResourceURI(String path) throws RuntimeException {
        try {
            return Util.class.getResource(path).toURI();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static File getTempDir(String path) throws Exception {
//        System.out.println("Temp Dir : " + System.getProperty("java.io.tmpdir") + " File : " + path);
        File tempdir = new File(System.getProperty("java.io.tmpdir"), path);
        tempdir.mkdirs();
//        System.out.println("tempdir : " + tempdir);
        return tempdir;
    }

    public static Element getElement(Node parent, int index) {
        int j = 0;
        NodeList nodes = parent.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                if (j == index) {
                    return (Element) node;
                }
                j++;
            }
        }
        return null;
    }
}
