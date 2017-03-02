package fi.linuxbox.swing.ch31.e4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PaintPanel extends JPanel {
    final Random random;

    public PaintPanel() {
        setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        random = new Random();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        final Insets insets = getInsets();
        final int width  = getWidth()  - insets.right - insets.left;
        final int height = getHeight() - insets.top   - insets.bottom;

        for (int i = 0; i < 10; i++) {
            final int x1 = insets.right + random.nextInt(width);
            final int y1 = insets.top   + random.nextInt(height);
            final int x2 = insets.right + random.nextInt(width);
            final int y2 = insets.top   + random.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }
    }
}
