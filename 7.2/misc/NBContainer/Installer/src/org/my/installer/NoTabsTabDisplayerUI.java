package org.my.installer;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SingleSelectionModel;
import javax.swing.plaf.ComponentUI;
import org.netbeans.swing.tabcontrol.TabDisplayer;
import org.netbeans.swing.tabcontrol.TabDisplayerUI;

public class NoTabsTabDisplayerUI extends TabDisplayerUI {

    public NoTabsTabDisplayerUI(TabDisplayer displayer) {
        super(displayer);
    }

    public static ComponentUI createUI(JComponent jc) {
        assert jc instanceof TabDisplayer;
        return new NoTabsTabDisplayerUI((TabDisplayer) jc);
    }
    private static final int[] PTS = new int[]{0, 0, 0};

    public Polygon getExactTabIndication(int i) {
        //Should never be called
        return new Polygon(PTS, PTS, PTS.length);
    }

    public Polygon getInsertTabIndication(int i) {
        return new Polygon(PTS, PTS, PTS.length);
    }

    public int tabForCoordinate(Point point) {
        return -1;
    }

    public Rectangle getTabRect(int i, Rectangle rectangle) {
        return new Rectangle(0, 0, 0, 0);
    }

    protected SingleSelectionModel createSelectionModel() {
        return new DefaultSingleSelectionModel();
    }

    public java.lang.String getCommandAtPoint(Point point) {
        return null;
    }

    public int dropIndexOfPoint(Point point) {
        return -1;
    }

    public void registerShortcuts(javax.swing.JComponent jComponent) {
        //do nothing
    }

    public void unregisterShortcuts(javax.swing.JComponent jComponent) {
        //do nothing
    }

    protected void requestAttention(int i) {
        //do nothing
    }

    protected void cancelRequestAttention(int i) {
        //do nothing
    }

    public Dimension getPreferredSize(javax.swing.JComponent c) {
        return new Dimension(0, 0);
    }

    public Dimension getMinimumSize(javax.swing.JComponent c) {
        return new Dimension(0, 0);
    }

    public Dimension getMaximumSize(javax.swing.JComponent c) {
        return new Dimension(0, 0);
    }
}
