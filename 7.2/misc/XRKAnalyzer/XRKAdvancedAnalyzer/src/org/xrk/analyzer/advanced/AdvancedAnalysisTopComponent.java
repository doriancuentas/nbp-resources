/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xrk.analyzer.advanced;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Confirmation;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileAttributeEvent;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileEvent;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileRenameEvent;
import org.openide.util.Exceptions;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.xrk.filesupport.XRKDataObject;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//org.xrk.analyzer.advanced//AdvancedAnalysis//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "AdvancedAnalysisTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "properties", openAtStartup = true)
@ActionID(category = "Window", id = "org.xrk.analyzer.advanced.AdvancedAnalysisTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_AdvancedAnalysisAction",
preferredID = "AdvancedAnalysisTopComponent")
@Messages({
    "CTL_AdvancedAnalysisAction=AdvancedAnalysis",
    "CTL_AdvancedAnalysisTopComponent=AdvancedAnalysis Window",
    "HINT_AdvancedAnalysisTopComponent=This is a AdvancedAnalysis window"
})
public final class AdvancedAnalysisTopComponent extends TopComponent implements LookupListener {

    private InstanceContent ic = new InstanceContent();
    private XRKDataObject dobj;

    public AdvancedAnalysisTopComponent() {
        initComponents();
        setName(Bundle.CTL_AdvancedAnalysisTopComponent());
        setToolTipText(Bundle.HINT_AdvancedAnalysisTopComponent());
        resultArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                fireChange();
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        associateLookup(new AbstractLookup(ic));
    }

    FileLock fileLock = null;

    public OutputStream outputStream() throws IOException {
        if (fileLock == null || !fileLock.isValid()) {
            fileLock = dobj.getPrimaryFile().lock();
        }
        try {
            return dobj.getPrimaryFile().getOutputStream(fileLock);
        } catch (IOException fse) {
            // [pnejedly] just retry once.
            // Ugly workaround for #40552
            if (fileLock == null || !fileLock.isValid()) {
                fileLock = dobj.getPrimaryFile().lock();
            }
            return dobj.getPrimaryFile().getOutputStream(fileLock);
        }
    }

    private void fireChange() {
        if (dobj != null) {
            if (getLookup().lookup(MySavable.class) == null) {
                ic.add(new MySavable());
            }
        }
    }

    private class MySavable extends AbstractSavable {

        MySavable() {
            register();
        }

        @Override
        protected String findDisplayName() {
            return dobj.getName();
        }

        @Override
        protected void handleSave() throws IOException {
                OutputStreamWriter ow = null;
                try {
                    ow = new OutputStreamWriter(outputStream());
                    ow.write(resultArea.getText());
                    ow.close();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                } finally {
                    try {
                        ow.close();
                        fileLock.releaseLock();
                    } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
                tc().ic.remove(this);
                unregister();
        }

        AdvancedAnalysisTopComponent tc() {
            return AdvancedAnalysisTopComponent.this;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MySavable) {
                MySavable m = (MySavable) obj;
                return tc() == m.tc();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return tc().hashCode();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();

        resultArea.setColumns(20);
        resultArea.setRows(5);
        jScrollPane1.setViewportView(resultArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultArea;
    // End of variables declaration//GEN-END:variables
    Result<XRKDataObject> allObjectsInApplicationContext;

    @Override
    public void resultChanged(LookupEvent le) {
        if (!allObjectsInApplicationContext.allInstances().isEmpty()) {
            XRKDataObject localDobj = allObjectsInApplicationContext.allInstances().iterator().next();
            final String content;
            try {
                content = localDobj.getPrimaryFile().asText();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        resultArea.setText(content);
                    }
                });
                localDobj.getPrimaryFile().addFileChangeListener(new FileChangeListener() {
                    @Override
                    public void fileFolderCreated(FileEvent fe) {
                    }

                    @Override
                    public void fileDataCreated(FileEvent fe) {
                    }
                    @Override
                    public void fileChanged(FileEvent fe) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    resultArea.setText(dobj.getPrimaryFile().asText());
                                } catch (IOException ex) {
                                    Exceptions.printStackTrace(ex);
                                }
                            }
                        });
                    }
                    @Override
                    public void fileDeleted(FileEvent fe) {
                    }
                    @Override
                    public void fileRenamed(FileRenameEvent fre) {
                    }
                    @Override
                    public void fileAttributeChanged(FileAttributeEvent fae) {
                    }
                });
                this.dobj = localDobj;
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    @Override
    public void componentOpened() {
        //when the window opens, start listening to the application context for objects
        allObjectsInApplicationContext = Utilities.actionsGlobalContext().lookupResult(XRKDataObject.class);
        allObjectsInApplicationContext.addLookupListener(
                this);
    }

    @Override
    public void componentClosed() {
        allObjectsInApplicationContext.removeLookupListener(this);
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
