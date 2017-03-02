package fi.linuxbox.swing.ch32.e3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JButtonDemo implements ActionListener {
    private final static Logger log = LoggerFactory.getLogger(JButtonDemo.class);

    private final JLabel label;

    public JButtonDemo() {
        label = new JLabel("Press a button.");

        final JFrame frame = new JFrame("JButton Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final ImageIcon icon = new ImageIcon(getClass().getResource("/hourglass.png"));

        frame.add(button(icon, "One"));
        frame.add(button(icon, "Two"));
        frame.add(button(icon, "Three"));
        frame.add(button(icon, "Four"));

        frame.add(label);

        frame.setVisible(true);
    }

    private JButton button(final ImageIcon icon, final String command) {
        final JButton button = new JButton(icon);
        button.setActionCommand(command);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        log.info("reacting...");
        label.setText(e.getActionCommand());
    }
}
