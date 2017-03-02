package fi.linuxbox.swing.ch31.e4;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PaintDemo {
    public PaintDemo() {
        final JFrame frame = new JFrame("Paint Demo");
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.add(new PaintPanel());

        frame.setVisible(true);
    }
}
