package fi.linuxbox.swing.ch32.e7;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JTabbedPaneDemo {
    public JTabbedPaneDemo() {
        final JFrame frame = new JFrame("JTabbedPane Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Cities", new CitiesPanel());
        tabbedPane.addTab("Colors", new ColorsPanel());
        tabbedPane.addTab("Flavors", new FlavorsPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
