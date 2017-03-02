package fi.linuxbox.swing.ch32.e7;

import javax.swing.*;
import java.awt.*;

public class ColorsPanel extends JPanel {
    public ColorsPanel() {
        add(new JCheckBox("Red"));
        add(new JCheckBox("Green"));
        add(new JCheckBox("Blue"));
    }
}
