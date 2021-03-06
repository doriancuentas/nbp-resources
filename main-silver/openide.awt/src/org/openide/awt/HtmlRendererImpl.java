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
package org.openide.awt;


import java.awt.*;
import java.awt.event.*;

import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;


import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;


/**
 * Html renderer component implementation.  The actual painting is done by HtmlLabelUI, which uses
 * HtmlRenderer.renderString().  What this class does:   Provide some methods for resetting its state
 * between uses (see HtmlRenderer.createLabel() for why), overrides for a bunch of things for performance
 * reasons, and some conversions to handle the case that the lightweight html renderer is disabled
 * (-J-Dnb.useSwingHtmlRendering=true), to convert our minor extensions to html syntax to standard
 * syntax for the swing renderer.
 * <p>
 * Mainly this class provides an implementation of the various cell renderer interfaces which
 * HtmlRenderer.Renderer aggregates, and the convenience methods it provides.
 *
 * @author Tim Boudreau
 * @since 4.30
 *
 */
class HtmlRendererImpl extends JLabel implements HtmlRenderer.Renderer {
    private static final Rectangle bounds = new Rectangle();
    private static final boolean swingRendering = Boolean.getBoolean("nb.useSwingHtmlRendering"); //NOI18N
    private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);
    enum Type {UNKNOWN, TREE, LIST, TABLE}

    //For experimentation - holding the graphics object may be the source of some
    //strange painting problems on Apple
    private static boolean noCacheGraphics = Boolean.getBoolean("nb.renderer.nocache"); //NOI18N
    private static Reference<Graphics> scratchGraphics = null;
    private boolean centered = false;
    private boolean parentFocused = false;
    private Boolean html = null;
    private int indent = 0;
    private Border border = null;
    private boolean selected = false;
    private boolean leadSelection = false;
    private Dimension prefSize = null;
    private Type type = Type.UNKNOWN;
    private int renderStyle = HtmlRenderer.STYLE_CLIP;
    private boolean enabled = true;

    /** Restore the renderer to a pristine state */
    public void reset() {
        parentFocused = false;
        setCentered(false);
        html = null;
        indent = 0;
        border = null;
        setIcon(null);
        setOpaque(false);
        selected = false;
        leadSelection = false;
        prefSize = null;
        type = Type.UNKNOWN;
        renderStyle = HtmlRenderer.STYLE_CLIP;
        setFont(UIManager.getFont("controlFont")); //NOI18N
        setIconTextGap(3);
        setEnabled(true);
        border = null;

        //Defensively ensure the insets haven't been messed with
        EMPTY_INSETS.top = 0;
        EMPTY_INSETS.left = 0;
        EMPTY_INSETS.right = 0;
        EMPTY_INSETS.bottom = 0;
    }

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean selected, boolean leadSelection, int row, int column
    ) {
        reset();
        configureFrom(value, table, selected, leadSelection);
        type = Type.TABLE;

        if (swingRendering && selected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
            setOpaque(true);
        }

        return this;
    }

    public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean leadSelection
    ) {
        reset();
        configureFrom(value, tree, selected, leadSelection);
        type = Type.TREE;

        if (swingRendering && selected) {
            if (HtmlLabelUI.isGTK()) {
                setBackground(HtmlLabelUI.getBackgroundFor(this));
                setForeground(HtmlLabelUI.getForegroundFor(this));
            }
            setOpaque(true);
        }

        return this;
    }

    public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean selected, boolean leadSelection
    ) {
        reset();
        configureFrom(value, list, selected, leadSelection);
        type = Type.LIST;

        if (swingRendering && selected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            setOpaque(true);
        }
        
        // ##93658: In GTK we have to paint borders in combo boxes 
        if (HtmlLabelUI.isGTK()) {
            if (index == -1) {
                Color borderC = UIManager.getColor("controlShadow");
                borderC = borderC == null ? Color.GRAY : borderC;
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(borderC),
                        BorderFactory.createEmptyBorder(3, 2, 3, 2)));
            } else {
                setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            }
        }

        return this;
    }

    /** Generic code to set properties appropriately from any of the renderer
     * fetching methods */
    private void configureFrom(Object value, JComponent target, boolean selected, boolean leadSelection) {
        if (value == null) {
            value = "";
        }

        setText((value == null) ? "" : value.toString());

        setSelected(selected);

        if (selected) {
            setParentFocused(checkFocused(target));
        } else {
            setParentFocused(false);
        }

        setEnabled(target.isEnabled());

        setLeadSelection(leadSelection);

        setFont(target.getFont());
    }

    private boolean checkFocused(JComponent c) {
        Component focused = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
        boolean result = c == focused;

        if (!result) {
            result = c.isAncestorOf(focused);
        }

        return result;
    }

    public @Override void addNotify() {
        if (swingRendering) {
            super.addNotify();
        }
    }

    public @Override void removeNotify() {
        if (swingRendering) {
            super.removeNotify();
        }
    }

    public void setSelected(boolean val) {
        selected = val;
    }

    public void setParentFocused(boolean val) {
        parentFocused = val;
    }

    public void setLeadSelection(boolean val) {
        leadSelection = val;
    }

    public void setCentered(boolean val) {
        centered = val;

        if (val) {
            setIconTextGap(5);
        }

        if (swingRendering) {
            if (val) {
                setVerticalTextPosition(JLabel.BOTTOM);
                setHorizontalAlignment(JLabel.CENTER);
                setHorizontalTextPosition(JLabel.CENTER);
            } else {
                setVerticalTextPosition(JLabel.CENTER);
                setHorizontalAlignment(JLabel.LEADING);
                setHorizontalTextPosition(JLabel.TRAILING);
            }
        }
    }

    public void setIndent(int pixels) {
        this.indent = pixels;
    }

    public void setHtml(boolean val) {
        Boolean wasHtml = html;
        String txt = getText();
        html = val ? Boolean.TRUE : Boolean.FALSE;

        if (swingRendering && (html != wasHtml)) {
            //Ensure label UI gets updated and builds its little document tree...
            firePropertyChange("text", txt, getText()); //NOI18N
        }
    }

    public void setRenderStyle(int style) {
        renderStyle = style;
    }

    int getRenderStyle() {
        return renderStyle;
    }

    boolean isLeadSelection() {
        return leadSelection;
    }

    boolean isCentered() {
        return centered;
    }

    boolean isParentFocused() {
        return parentFocused;
    }

    boolean isHtml() {
        if (html == null) {
            String s = getText();
            html = checkHtml(s);
        }

        return html.booleanValue();
    }

    private Boolean checkHtml(String s) {
        Boolean result;

        if (s == null) {
            result = Boolean.FALSE;
        } else if (s.startsWith("<html") || s.startsWith("<HTML")) { //NOI18N
            result = Boolean.TRUE;
        } else {
            result = Boolean.FALSE;
        }

        return result;
    }

    boolean isSelected() {
        return selected;
    }

    int getIndent() {
        return indent;
    }

    Type getType() {
        return type;
    }

    public @Override Dimension getPreferredSize() {
        if (!swingRendering) {
            if (prefSize == null) {
                prefSize = getUI().getPreferredSize(this);
            }

            return prefSize;
        } else {
            return super.getPreferredSize();
        }
    }

    /**
     * Overridden for the case that we're running with the lightweight html renderer disabled, to convert
     * any less-than-legal html to legal html for purposes of Swing's html rendering.
     *
     * @return The text - unless the renderer is disabled, this just return super.getText()
     */
    public @Override String getText() {
        String result = super.getText();

        if (swingRendering && Boolean.TRUE.equals(html)) {
            //Standard swing rendering needs an opening HTML tag to function, so make sure there is
            //one if we're not using HtmlLabelUI
            result = ensureHtmlTags(result);
        } else if (swingRendering && (html == null)) {
            //Cannot call isHtml() here, it will create an endless loop, so manually check the HTML status
            html = checkHtml(super.getText());

            if (Boolean.TRUE.equals(html)) {
                result = ensureHtmlTags(result);
            }
        }

        return result;
    }

    /**
     * Converts our extended html syntax (allowing UIManager color keys and omitting opening html tags
     * into standard html.  Only called if the lightweight html renderer is disabled and we're running with
     * a standard JLabel UI
     *
     * @param s The string that is the text of the label
     * @return The same string converted to standard HTML Swing's rendering infrastructure will know what to do
     *         with
     */
    private String ensureHtmlTags(String s) {
        s = ensureLegalFontColorTags(s);

        if (!s.startsWith("<HTML") && !s.startsWith("<html")) { //NOI18N
            s = "<html>" + s + "</html>"; //NOI18N
        }

        return s;
    }

    /**
     * Converts extended UI manager color tags into legal html in the case that we're using swing rendering
     *
     * @param s string to convert if it has questionable font tags
     * @return The converted string
     */
    private static String ensureLegalFontColorTags(String s) {
        String check = s.toUpperCase();
        int start = 0;
        int fidx = check.indexOf("<FONT", start); //NOI18N
        StringBuffer sb = null;

        if ((fidx != -1) && (fidx <= s.length())) {
            while ((fidx != -1) && (fidx <= s.length())) {
                int cidx = check.indexOf("COLOR", start); //NOI18N
                int tagEnd = check.indexOf('>', start); //NOI18N
                start = tagEnd + 1;

                if (tagEnd == -1) {
                    break;
                }

                if (cidx != -1) {
                    if (cidx < tagEnd) {
                        //we have a font color tag
                        int eidx = check.indexOf('=', cidx); //NOI18N

                        if (eidx != -1) {
                            int bangIdx = check.indexOf('!', eidx); //NOI18N

                            if ((bangIdx != -1) && (bangIdx < tagEnd)) {
                                int colorStart = bangIdx + 1;
                                int colorEnd = tagEnd;

                                for (int i = colorStart; i < tagEnd; i++) {
                                    char c = s.charAt(i);

                                    if (!Character.isLetter(c)) {
                                        colorEnd = i;

                                        break;
                                    }
                                }

                                if (sb == null) {
                                    sb = new StringBuffer(s);
                                }

                                String colorString = s.substring(colorStart, colorEnd);
                                String converted = convertToStandardColor(colorString);
                                sb.replace(bangIdx, colorEnd, converted);
                                s = sb.toString();
                                check = s.toUpperCase();
                            }
                        }
                    }
                }

                fidx = check.indexOf("<FONT", start); //NOI18N
                start = fidx;
            }
        }

        if (sb != null) {
            return sb.toString();
        } else {
            return s;
        }
    }

    /**
     * Creates a standard html #nnnnnn string from a string representing a UIManager key.  If the color is not found,
     * black will be used.  Only used if the lightweight html renderer is disabled.
     *
     * @param colorString  A string found after a ! character in a color definition, which needs to be converted to
     *        standard HTML
     * @return A hex number string
     */
    private static String convertToStandardColor(String colorString) {
        Color c = UIManager.getColor(colorString);

        if (c == null) {
            c = Color.BLACK;
        }

        StringBuffer sb = new StringBuffer(7);
        sb.append('#');
        sb.append(hexString(c.getRed()));
        sb.append(hexString(c.getGreen()));
        sb.append(hexString(c.getBlue()));

        return sb.toString();
    }

    /**
     * Gets a hex string for an integer.  Ensures the result is always two characters long, which is not
     * true of Integer.toHexString().
     *
     * @param r an integer < 255
     * @return a 2 character hexadecimal string
     */
    private static String hexString(int r) {
        String s = Integer.toHexString(r);

        if (s.length() == 1) {
            s = '0' + s;
        }

        return s;
    }

    /** Overridden to do nothing under normal circumstances.  If the boolean flag to <strong>not</strong> use the
     * internal HTML renderer is in effect, this will fire changes normally */
    protected @Override final void firePropertyChange(String name, Object old, Object nue) {
        if (swingRendering) {
            if ("text".equals(name) && isHtml()) {
                //Force in the HTML tags so the UI will set up swing HTML rendering appropriately
                nue = getText();
            }

            super.firePropertyChange(name, old, nue);
        }
    }

    public @Override Border getBorder() {
        Border result;

        if ((indent != 0) && swingRendering) {
            result = BorderFactory.createEmptyBorder(0, indent, 0, 0);
        } else {
            result = border;
        }

        return result;
    }

    public @Override void setBorder(Border b) {
        Border old = border;
        border = b;

        if (swingRendering) {
            firePropertyChange("border", old, b);
        }
    }

    public @Override Insets getInsets() {
        return getInsets(null);
    }

    public @Override Insets getInsets(Insets insets) {
        Insets result;

        //Call getBorder(), not just read the field - if swingRendering, the border will be constructed, and the
        //insets are what will make the indent property work;  HtmlLabelUI doesn't need this, it just reads the
        //insets property, but BasicLabelUI and its ilk do
        Border b = getBorder();

        if (b == null) {
            result = EMPTY_INSETS;
        } else {
            //workaround for open jdk bug, see issue #192388
            try {
                result = b.getBorderInsets(this);
            } catch( NullPointerException e ) {
                Logger.getLogger(HtmlRendererImpl.class.getName()).log(Level.FINE, null, e);
                result = EMPTY_INSETS;
            }
        }
        if( null != insets ) {
            insets.set( result.top, result.left, result.bottom, result.right);
            return insets;
        }
        return result;
    }

    public @Override void setEnabled(boolean b) {
        //OptimizeIt shows about 12Ms overhead calling back to Component.enable(), so avoid it if possible
        enabled = b;

        if (swingRendering) {
            super.setEnabled(b);
        }
    }

    public @Override boolean isEnabled() {
        return enabled;
    }

    public @Override void updateUI() {
        if (swingRendering) {
            super.updateUI();
        } else {
            setUI(HtmlLabelUI.createUI(this));
        }
    }

    /** Overridden to produce a graphics object even when isDisplayable() is
     * false, so that calls to getPreferredSize() will return accurate
     * dimensions (presuming the font and text are set correctly) even when
     * not onscreen. */
    public @Override Graphics getGraphics() {
        Graphics result = null;

        if (isDisplayable()) {
            result = super.getGraphics();
        }

        if (result == null) {
            result = scratchGraphics();
        }

        return result;
    }

    /** Fetch a scratch graphics object for calculating preferred sizes while
     * offscreen */
    private static final Graphics scratchGraphics() {
        Graphics result = null;

        if (scratchGraphics != null) {
            result = scratchGraphics.get();

            if (result != null) {
                result.setClip(null); //just in case somebody did something nasty
            }
        }

        if (result == null) {
            result = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
                                        .createCompatibleImage(1, 1).getGraphics();

            if (!noCacheGraphics) {
                scratchGraphics = new SoftReference<Graphics>(result);
            }
        }

        return result;
    }

    public @Override void setBounds(int x, int y, int w, int h) {
        if (swingRendering) {
            super.setBounds(x, y, w, h);
        }

        bounds.setBounds(x, y, w, h);
    }

    @Deprecated
    public @Override void reshape(int x, int y, int w, int h) {
        if (swingRendering) {
            super.reshape(x, y, w, h);
        }
    }

    public @Override int getWidth() {
        return bounds.width;
    }

    public @Override int getHeight() {
        return bounds.height;
    }

    public @Override Point getLocation() {
        return bounds.getLocation();
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void validate() {
        //do nothing
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void repaint(long tm, int x, int y, int w, int h) {
        //do nothing
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void repaint() {
        //do nothing
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void invalidate() {
        //do nothing
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void revalidate() {
        //do nothing
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addAncestorListener(AncestorListener l) {
        if (swingRendering) {
            super.addAncestorListener(l);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addComponentListener(ComponentListener l) {
        if (swingRendering) {
            super.addComponentListener(l);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addContainerListener(ContainerListener l) {
        if (swingRendering) {
            super.addContainerListener(l);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addHierarchyListener(HierarchyListener l) {
        if (swingRendering) {
            super.addHierarchyListener(l);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addHierarchyBoundsListener(HierarchyBoundsListener l) {
        if (swingRendering) {
            super.addHierarchyBoundsListener(l);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addInputMethodListener(InputMethodListener l) {
        if (swingRendering) {
            super.addInputMethodListener(l);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addFocusListener(FocusListener fl) {
        if (swingRendering) {
            super.addFocusListener(fl);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addMouseListener(MouseListener ml) {
        if (swingRendering) {
            super.addMouseListener(ml);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addMouseWheelListener(MouseWheelListener ml) {
        if (swingRendering) {
            super.addMouseWheelListener(ml);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addMouseMotionListener(MouseMotionListener ml) {
        if (swingRendering) {
            super.addMouseMotionListener(ml);
        }
    }

    /** Overridden to do nothing for performance reasons */
    public @Override void addVetoableChangeListener(VetoableChangeListener vl) {
        if (swingRendering) {
            super.addVetoableChangeListener(vl);
        }
    }

    /** Overridden to do nothing for performance reasons, unless using standard swing rendering */
    public @Override void addPropertyChangeListener(String s, PropertyChangeListener l) {
        if (swingRendering) {
            super.addPropertyChangeListener(s, l);
        }
    }

    public @Override void addPropertyChangeListener(PropertyChangeListener l) {
        if (swingRendering) {
            super.addPropertyChangeListener(l);
        }
    }
}
