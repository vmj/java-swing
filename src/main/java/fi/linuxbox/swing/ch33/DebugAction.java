package fi.linuxbox.swing.ch33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.security.Key;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;

public class DebugAction extends AbstractAction {
    private final ActionListener actionListener;

    public DebugAction(final String name, final Icon icon, final int mnem, final int accel, final String toolTip, final ActionListener actionListener) {
        super(name, icon);
        this.actionListener = actionListener;
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accel, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        putValue(MNEMONIC_KEY, mnem);
        putValue(SHORT_DESCRIPTION, toolTip);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        actionListener.actionPerformed(e);
    }
}
