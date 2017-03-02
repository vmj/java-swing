package fi.linuxbox.swing.ch32.ec;

import fi.linuxbox.swing.ch32.e7.JTabbedPaneDemo;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JTableDemo {
    private final static String[] COLUMNS =
            { "Name", "Extension", "ID#" };
    private final static Object[][] DATA = {
            { "Gail",     "4567", "865" },
            { "Ken",      "7566", "555" },
            { "Vivianne", "5634", "587" },
            { "Melanie",  "7345", "922" },
            { "Anne",     "1237", "333" },
            { "John",     "5656", "314" },
            { "Matt",     "5672", "217" },
            { "Claire",   "6741", "444" },
            { "Erwin",    "9023", "519" },
            { "Ellen",    "1134", "532" },
            { "Jennifer", "5689", "112" },
            { "Ed",       "9030", "133" },
            { "Helen",    "6751", "145" }
    };

    public JTableDemo() {
        final JFrame frame = new JFrame("JTable Demo");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.add(new JScrollPane(new JTable(DATA, COLUMNS)));

        frame.setVisible(true);
    }
}
