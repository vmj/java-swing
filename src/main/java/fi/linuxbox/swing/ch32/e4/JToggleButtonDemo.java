package fi.linuxbox.swing.ch32.e4;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JToggleButtonDemo {
    public JToggleButtonDemo() {
        final JFrame frame = new JFrame("JToggleButton Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JLabel label = new JLabel("Button is off");
        final JToggleButton button = new JToggleButton("On/Off");

        button.addActionListener(e -> {
            label.setText("Button is " + (button.isSelected() ? "on" : "off"));
        });

        frame.add(button);
        frame.add(label);

        frame.setVisible(true);
    }
}
