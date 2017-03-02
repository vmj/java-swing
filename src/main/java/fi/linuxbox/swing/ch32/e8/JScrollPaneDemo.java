package fi.linuxbox.swing.ch32.e8;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JScrollPaneDemo {
    public JScrollPaneDemo() {
        final JFrame frame = new JFrame("JScrollPane Demo");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 20));

        int b = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                panel.add(new JButton("Button " + b));
                b++;
            }
        }

        final JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
