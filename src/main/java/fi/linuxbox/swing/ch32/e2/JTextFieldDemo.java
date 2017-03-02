package fi.linuxbox.swing.ch32.e2;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JTextFieldDemo {
    public JTextFieldDemo() {
        final JFrame frame = new JFrame("JTextField Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 50);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JTextField textField = new JTextField(15);

        textField.addActionListener(e -> frame.setTitle(textField.getText()));

        frame.add(textField);
        frame.setVisible(true);
    }
}
