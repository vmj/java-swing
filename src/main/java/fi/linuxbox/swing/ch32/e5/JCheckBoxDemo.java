package fi.linuxbox.swing.ch32.e5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JCheckBoxDemo implements ItemListener {
    private final Set<String> selected = new HashSet<>();
    private final JLabel label;

    public JCheckBoxDemo() {
        label = new JLabel("Nothing is selected");

        final JFrame frame = new JFrame("JCheckBox Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.add(checkBox("C"));
        frame.add(checkBox("Java"));
        frame.add(checkBox("Groovy"));
        frame.add(checkBox("Python"));

        frame.add(label);

        frame.setVisible(true);
    }

    private JCheckBox checkBox(final String title) {
        final JCheckBox checkBox = new JCheckBox(title);
        checkBox.addItemListener(this);
        return checkBox;
    }

    @Override
    public void itemStateChanged(final ItemEvent e) {
        final JCheckBox checkBox = (JCheckBox) e.getItem();

        if (checkBox.isSelected())
            selected.add(checkBox.getText());
        else
            selected.remove(checkBox.getText());

        final Optional<String> languages = selected.stream().reduce((s, s2) -> s + ", " + s2);

        label.setText(languages.orElseGet(() -> "Nothing is selected"));
    }
}
