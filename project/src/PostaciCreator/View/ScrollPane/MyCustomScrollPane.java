package PostaciCreator.View.ScrollPane;

import javax.swing.*;
import java.awt.*;

public class MyCustomScrollPane extends JScrollPane {
    private static final int SB_SIZE = 10;

    public MyCustomScrollPane(Component view) {
        this(view, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public MyCustomScrollPane(int vsbPolicy, int hsbPolicy) {
        this(null, vsbPolicy, hsbPolicy);
    }

    public MyCustomScrollPane(Component view, int vsbPolicy, int hsbPolicy) {

        setBorder(null);

        setVerticalScrollBarPolicy(vsbPolicy);
        setHorizontalScrollBarPolicy(hsbPolicy);

        setBorder(BorderFactory.createEmptyBorder());

        // Set ScrollBar UI
        JScrollBar verticalScrollBar = getVerticalScrollBar();
        verticalScrollBar.setOpaque(false);
        verticalScrollBar.setUI(new MyCustomScrollbar());

        JScrollBar horizontalScrollBar = getHorizontalScrollBar();
        horizontalScrollBar.setOpaque(false);
        horizontalScrollBar.setUI(new MyCustomScrollbar());

        setLayout(new MyScrollPaneLayout());

        // Layering
        setComponentZOrder(getVerticalScrollBar(), 0);
        setComponentZOrder(getHorizontalScrollBar(), 1);
        setComponentZOrder(getViewport(), 2);

        viewport.setView(view);
    }


}
