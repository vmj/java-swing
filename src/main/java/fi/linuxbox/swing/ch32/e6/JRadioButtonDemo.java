package fi.linuxbox.swing.ch32.e6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JRadioButtonDemo {
    public JRadioButtonDemo() {
        final JFrame frame = new JFrame("JRadioButton Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JLabel label = new JLabel("Nothing is selected");

        final ButtonGroup group = new ButtonGroup();

        frame.add(radioButton("C", group, label));
        frame.add(radioButton("Java", group, label));
        frame.add(radioButton("Groovy", group, label));
        frame.add(radioButton("Python", group, label));

        frame.add(label);

        frame.setVisible(true);
    }

    private JRadioButton radioButton(final String title, final ButtonGroup group, final JLabel label) {
        final JRadioButton radioButton = new JRadioButton(title);
        radioButton.addActionListener(e -> label.setText(e.getActionCommand()));
        group.add(radioButton);
        return radioButton;
    }
}
