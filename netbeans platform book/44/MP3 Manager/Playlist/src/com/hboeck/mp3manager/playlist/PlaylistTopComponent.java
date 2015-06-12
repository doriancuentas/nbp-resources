/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hboeck.mp3manager.playlist;

import com.hboeck.mp3manager.filetype.Mp3DataObject;
import com.hboeck.mp3manager.services.player.Mp3Player;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.nodes.AbstractNode;
import org.openide.util.NbPreferences;
import org.openide.windows.WindowManager;


@ConvertAsProperties(dtd = "-//com.hboeck.mp3manager.playlist//Playlist//EN",
autostore = false)
@TopComponent.Description(preferredID = "PlaylistTopComponent",
iconBase = "com/hboeck/mp3manager/playlist/playlist.png",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.hboeck.mp3manager.playlist.PlaylistTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_PlaylistAction")
public final class PlaylistTopComponent extends TopComponent implements ExplorerManager.Provider {

   private static final String PREF_CURRENTDIR = "playlist.currentdir";

   private static final Preferences PREF = NbPreferences.forModule(PlaylistTopComponent.class);
   private static final Logger LOG = Logger.getLogger(PlaylistTopComponent.class.getName());

   private String id = "";

   private ExplorerManager manager   = new ExplorerManager();
   private PlaylistView    playlist  = new PlaylistView();
   private NodeContainer   container = new NodeContainer();
   
   public PlaylistTopComponent() {
      initComponents();
      setName(NbBundle.getMessage(PlaylistTopComponent.class, "CTL_PlaylistTopComponent"));
      setToolTipText(NbBundle.getMessage(PlaylistTopComponent.class, "HINT_PlaylistTopComponent"));

      manager.setRootContext(new AbstractNode(container));
      playlist.setDefaultActionProcessor(new Play());

      associateLookup(ExplorerUtils.createLookup(manager, getActionMap()));
   }

   @Override
   public ExplorerManager getExplorerManager() {
      return manager;
   }
   
   private final class Play implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         Mp3Player.getDefault().play(
                 container.getRemaining(
                 manager.getSelectedNodes()[0]));
      }
      
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      panel = new javax.swing.JPanel();
      toolbar = new javax.swing.JToolBar();
      add = new javax.swing.JButton();
      remove = new javax.swing.JButton();
      rename = new javax.swing.JButton();

      panel.setLayout(new java.awt.BorderLayout());
      panel.add(playlist, BorderLayout.CENTER);

      toolbar.setRollover(true);

      add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hboeck/mp3manager/playlist/add.png"))); // NOI18N
      org.openide.awt.Mnemonics.setLocalizedText(add, org.openide.util.NbBundle.getMessage(PlaylistTopComponent.class, "PlaylistTopComponent.add.text")); // NOI18N
      add.setToolTipText(org.openide.util.NbBundle.getMessage(PlaylistTopComponent.class, "PlaylistTopComponent.add.toolTipText")); // NOI18N
      add.setFocusable(false);
      add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      add.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addActionPerformed(evt);
         }
      });
      toolbar.add(add);

      remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hboeck/mp3manager/playlist/delete.png"))); // NOI18N
      org.openide.awt.Mnemonics.setLocalizedText(remove, org.openide.util.NbBundle.getMessage(PlaylistTopComponent.class, "PlaylistTopComponent.remove.text")); // NOI18N
      remove.setToolTipText(org.openide.util.NbBundle.getMessage(PlaylistTopComponent.class, "PlaylistTopComponent.remove.toolTipText")); // NOI18N
      remove.setFocusable(false);
      remove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      remove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      remove.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeActionPerformed(evt);
         }
      });
      toolbar.add(remove);

      rename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hboeck/mp3manager/playlist/rename.png"))); // NOI18N
      org.openide.awt.Mnemonics.setLocalizedText(rename, org.openide.util.NbBundle.getMessage(PlaylistTopComponent.class, "PlaylistTopComponent.rename.text")); // NOI18N
      rename.setToolTipText(org.openide.util.NbBundle.getMessage(PlaylistTopComponent.class, "PlaylistTopComponent.rename.toolTipText")); // NOI18N
      rename.setFocusable(false);
      rename.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      rename.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      rename.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            renameActionPerformed(evt);
         }
      });
      toolbar.add(rename);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 400, Short.MAX_VALUE)
         .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
         .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 300, Short.MAX_VALUE)
         .addGroup(layout.createSequentialGroup()
            .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents

   private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
      JFileChooser fc = new JFileChooser(PREF.get(PREF_CURRENTDIR, ""));
      fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      fc.setFileFilter(new FileNameExtensionFilter("MP3 Files", "mp3"));
      fc.setMultiSelectionEnabled(true);
      
      if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
         addAllFiles(fc.getSelectedFiles());
         PREF.put(PREF_CURRENTDIR, fc.getCurrentDirectory().getAbsolutePath());
      }
}//GEN-LAST:event_addActionPerformed

   private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
      container.remove(manager.getSelectedNodes());
}//GEN-LAST:event_removeActionPerformed

   private void renameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameActionPerformed
      NotifyDescriptor.InputLine nf = new NotifyDescriptor.InputLine("New Playlist Name", "Rename");
      nf.setInputText(getName());
      if(DialogDisplayer.getDefault().notify(nf) == NotifyDescriptor.OK_OPTION) {
         setName(nf.getInputText());
      }
}//GEN-LAST:event_renameActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton add;
   private javax.swing.JPanel panel;
   private javax.swing.JButton remove;
   private javax.swing.JButton rename;
   private javax.swing.JToolBar toolbar;
   // End of variables declaration//GEN-END:variables
   @Override
   public void componentOpened() {
      id = WindowManager.getDefault().findTopComponentID(this);
      LOG.log(Level.INFO, "Load playlist with ID: {0}", id);
      container.load(id);
   }

   @Override
   public void componentClosed() {
      // TODO add custom code on component closing
   }

   void writeProperties(java.util.Properties p) {
      // better to version settings since initial version as advocated at
      // http://wiki.apidesign.org/wiki/PropertyFiles
      p.setProperty("version", "1.0");

      LOG.log(Level.INFO, "Save playlist with ID: {0}", id);
      container.update(id);
   }

   void readProperties(java.util.Properties p) {
      String version = p.getProperty("version");
      // TODO read your settings according to their version
   }
   
   private void addAllFiles(File[] files) {
      for(File f : files) {
         if(f.isFile()) {
            try {
               container.add(Mp3DataObject.find(f).getNodeDelegate());
            } catch(Exception e) {}
         } else if(f.isDirectory()) {
            addAllFiles(f.listFiles());
         }
      }
   }
}