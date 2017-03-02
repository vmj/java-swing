package fi.linuxbox.swing.ch32.e9;

import javax.swing.*;

import java.awt.*;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JListDemo {
    private final static String[] CITIES = {
            "New York", "Chicago", "Houston", "Denver", "Los Angeles", "Seattle", "London", "Paris", "New Delhi",
            "Hong Kong", "Tokyo", "Sydney"
    };

    public JListDemo() {
        final JFrame frame = new JFrame("JList Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 120);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JList<String> list = new JList<>(CITIES);
        list.setSelectionMode(SINGLE_SELECTION);

        final JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(120, 90));

        final JLabel label = new JLabel("Choose a city");

        list.addListSelectionListener(e -> {
            final int idx = list.getSelectedIndex();
            label.setText(idx != -1 ? "Current selection: " + CITIES[idx] : "Choose a city");
        });

        frame.add(scrollPane);
        frame.add(label);
        frame.setVisible(true);
    }
}
