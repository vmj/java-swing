package fi.linuxbox.swing.ch31.e2;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EventDemo {
    final JLabel label;

    public EventDemo() {
        label = new JLabel("Press a button.");

        final JFrame frame = new JFrame("An Event Example");
        frame.setLayout(new FlowLayout());
        frame.setSize(220, 90);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.add(button("Alpha", "Alpha was pressed."));
        frame.add(button("Beta", "Beta was pressed."));
        frame.add(label);
        frame.setVisible(true);
    }

    private JButton button(final String title, final String message) {
        final JButton button = new JButton(title);
        button.addActionListener(e -> label.setText(message));
        return button;
    }
}
