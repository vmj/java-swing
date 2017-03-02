package fi.linuxbox.swing.ch31.e1;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SwingDemo {
    public SwingDemo() {
        final JFrame frame = new JFrame("A Window Title");
        frame.setSize(275, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JLabel label = new JLabel("Label Title");

        frame.add(label);

        frame.setVisible(true);
    }
}
