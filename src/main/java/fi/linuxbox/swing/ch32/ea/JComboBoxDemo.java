package fi.linuxbox.swing.ch32.ea;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JComboBoxDemo {
    private final static String[] LABELS = { "One", "Two", "Three", "Four" };

    public JComboBoxDemo() {
        final JFrame frame = new JFrame("JComboBox Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 120);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JComboBox<String> comboBox = new JComboBox<>(LABELS);
        final JLabel label = new JLabel("Choose one");

        comboBox.addActionListener(e -> {
            label.setText((String)comboBox.getSelectedItem());
        });

        frame.add(comboBox);
        frame.add(label);
        frame.setVisible(true);
    }
}
