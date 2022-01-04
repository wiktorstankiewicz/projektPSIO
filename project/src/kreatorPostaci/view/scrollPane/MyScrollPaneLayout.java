/*
    Naprawia wyswietlanie calej zawartosci JScrollPane
    horyzontalnie
    W przeciwnym wypadku pionowy scrollbar zaslania czesc
    zawartosci i pojawia sie scrollbar horyzontalny

    zrodla: https://stackoverflow.com/questions/11587292/jscrollpane-not-wide-enough-when-vertical-scrollbar-appears
            https://stackoverflow.com/questions/16373459/java-jscrollbar-design
 */

package kreatorPostaci.view.scrollPane;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;


public class MyScrollPaneLayout extends ScrollPaneLayout {
    private static final int SB_SIZE = 10;
    @Serial
    private static final long serialVersionUID = -9113524826510646757L;

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim =  super.preferredLayoutSize(parent);
        JScrollPane pane = (JScrollPane) parent;
        Component comp = pane.getViewport().getView();
        Dimension viewPref = comp.getPreferredSize();
        Dimension port = pane.getViewport().getExtentSize();
        if (port.height <= viewPref.height) {
//            System.out.println("Pane width: " + dim.width);
//            System.out.println("After adding: " + dim.width + pane.getVerticalScrollBar().getPreferredSize().width);
            dim.width += pane.getVerticalScrollBar().getPreferredSize().width;
        }
        return dim;
    }

    @Override
    public void layoutContainer(Container parent) {
//        super.layoutContainer(parent);
        Rectangle availR = parent.getBounds();
        availR.x = availR.y = 0;

        boolean vsbNeeded = isVerticalScrollBarNecessary();
        boolean hsbNeeded = isHorizontalScrollBarNecessary();

        // viewport
        Insets insets = parent.getInsets();
        availR.x = insets.left;
        availR.y = insets.top;
        availR.width -= insets.left + insets.right;
        availR.height -= insets.top + insets.bottom;

        if ((vsb != null) && vsbNeeded){
            availR.width -= SB_SIZE;
        }

        if (viewport != null) {
            viewport.setBounds(availR);
        }


        // vertical scroll bar
        Rectangle vsbR = new Rectangle();
        vsbR.width = SB_SIZE;
        vsbR.height = availR.height - (hsbNeeded ? vsbR.width : 0);
        vsbR.x = availR.x + availR.width - vsbR.width + SB_SIZE;
        vsbR.y = availR.y;
        if (vsb != null) {
            vsb.setBounds(vsbR);
        }

        // horizontal scroll bar
        Rectangle hsbR = new Rectangle();
        hsbR.height = SB_SIZE;
        hsbR.width = availR.width - (vsbNeeded ? hsbR.height : 0);
        hsbR.x = availR.x;
        hsbR.y = availR.y + availR.height - hsbR.height;
        if (hsb != null) {
            hsb.setBounds(hsbR);
        }
    }

    private boolean isVerticalScrollBarNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getHeight() > viewRect.getHeight();
    }

    private boolean isHorizontalScrollBarNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getWidth() > viewRect.getWidth();
    }
}