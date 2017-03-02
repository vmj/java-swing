package fi.linuxbox.swing.ch32.e1;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JLabelDemo {
    public JLabelDemo() {
        final JFrame frame = new JFrame("Label Demo");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final ImageIcon icon = new ImageIcon(getClass().getResource("/hourglass.png"));
        final JLabel label = new JLabel("Hourglass", icon, CENTER);

        frame.add(label);

        frame.setVisible(true);
    }
}
