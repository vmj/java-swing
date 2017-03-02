package fi.linuxbox.swing.ch32.e7;

import javax.swing.*;
import java.awt.*;

public class FlavorsPanel extends JPanel {
    public FlavorsPanel() {
        final JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Vanilla");
        comboBox.addItem("Chocolate");
        comboBox.addItem("Strawberry");
        add(comboBox);
    }
}
