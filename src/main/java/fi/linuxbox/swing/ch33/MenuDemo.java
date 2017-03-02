package fi.linuxbox.swing.ch33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.KeyEvent.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuDemo implements ActionListener {
    private JLabel label;

    private DebugAction setAction;
    private DebugAction clearAction;
    private DebugAction resumeAction;

    public MenuDemo() {
        final JFrame frame = new JFrame("Complete Menu Demo");
        frame.setLayout(new BorderLayout());
        frame.setSize(360, 200);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        makeActions(this); // does not depend on anything

        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(makeFileMenu(this));
        menuBar.add(makeOptionsMenu(this)); // the Debug submenu depends on actions
        menuBar.add(makeHelpMenu(this));
        frame.setJMenuBar(menuBar);

        final JToolBar toolBar = makeToolBar(); // depends on actions
        frame.add(toolBar, NORTH);

        label = new JLabel();
        frame.add(label, CENTER);

        final JPopupMenu popupMenu = makeEditPopupMenu(this);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger())
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        final String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Exit":
                System.exit(0);
                break;
            case "Set breakpoint":
                clearAction.setEnabled(true);
                setAction.setEnabled(false);
                break;
            case "Clear breakpoint":
                clearAction.setEnabled(false);
                setAction.setEnabled(true);
                break;
        }

        label.setText(actionCommand + " selected");
    }

    private static JMenu makeFileMenu(final ActionListener actionListener) {
        final JMenu menu = new JMenu("File");
        menu.setMnemonic(VK_F);
        menu.add(menuItem("Open", VK_O, actionListener));
        menu.add(menuItem("Close", VK_C, actionListener));
        menu.add(menuItem("Save", VK_S, actionListener));
        menu.addSeparator();
        menu.add(menuItem("Exit", VK_E, actionListener));
        return menu;
    }

    private JMenu makeOptionsMenu(final ActionListener actionListener) {
        final JMenu menu = new JMenu("Options");
        menu.add(makeColorsMenu(actionListener));
        menu.add(makePriorityMenu(actionListener));
        menu.add(makeDebugMenu());
        menu.addSeparator();
        menu.add(menuItem("Reset", actionListener));
        return menu;
    }

    private static JMenu makeHelpMenu(final ActionListener actionListener) {
        final JMenu menu = new JMenu("Help");

        menu.add(menuItem("About", actionListener)); // TODO: Add help icon and tool tip

        return menu;
    }

    private void makeActions(final ActionListener actionListener) {
        setAction = new DebugAction(
                "Set breakpoint",
                null,
                VK_S,
                VK_B,
                "Set a break point",
                actionListener);
        clearAction = new DebugAction(
                "Clear breakpoint",
                null,
                VK_C,
                VK_L,
                "Clean a break point",
                actionListener);
        resumeAction = new DebugAction(
                "Resume",
                null,
                VK_R,
                VK_R,
                "Resume  execution after break point",
                actionListener);

        clearAction.setEnabled(false);
    }

    private JToolBar makeToolBar() {
        final JToolBar toolBar = new JToolBar("Breakpoints");
        toolBar.add(new JButton(setAction));
        toolBar.add(new JButton(clearAction));
        toolBar.add(new JButton(resumeAction));
        return toolBar;
    }

    private JMenu makeDebugMenu() {
        final JMenu menu = new JMenu("Debug");
        menu.add(new JMenuItem(setAction));
        menu.add(new JMenuItem(clearAction));
        menu.add(new JMenuItem(resumeAction));
        return menu;
    }

    private static JPopupMenu makeEditPopupMenu(final ActionListener actionListener) {
        final JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(menuItem("Cut", actionListener));
        popupMenu.add(menuItem("Copy", actionListener));
        popupMenu.add(menuItem("Paste", actionListener));

        return popupMenu;
    }

    private static JMenu makeColorsMenu(final ActionListener actionListener) {
        final JMenu menu = new JMenu("Colors");
        menu.add(checkBoxMenuItem("Red", actionListener));
        menu.add(checkBoxMenuItem("Green", actionListener));
        menu.add(checkBoxMenuItem("Blue", actionListener));
        return menu;
    }

    private static JMenu makePriorityMenu(final ActionListener actionListener) {
        final JMenu menu = new JMenu("Priority");

        final JRadioButtonMenuItem high = radioButtonMenuItem("High", true, actionListener);
        final JRadioButtonMenuItem low = radioButtonMenuItem("Low", false, actionListener);

        buttonGroup(high, low);

        menu.add(high);
        menu.add(low);

        return menu;
    }

    private static JMenuItem menuItem(final String text, final ActionListener actionListener) {
        final JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    private static JMenuItem menuItem(final String text, final int keyCode, final ActionListener actionListener) {
        return menuItem(text, keyCode, keyCode, actionListener);
    }

    private static JMenuItem menuItem(final String text, final int mnemonic, final int accelerator, final ActionListener actionListener) {
        final JMenuItem menuItem = new JMenuItem(text, mnemonic);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    private static JCheckBoxMenuItem checkBoxMenuItem(final String text, final ActionListener actionListener) {
        final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(text);
        checkBoxMenuItem.addActionListener(actionListener);
        return checkBoxMenuItem;
    }

    private static JRadioButtonMenuItem radioButtonMenuItem(final String text, final boolean selected, final ActionListener actionListener) {
        final JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem(text, selected);
        radioButtonMenuItem.addActionListener(actionListener);
        return radioButtonMenuItem;
    }

    private static ButtonGroup buttonGroup(final AbstractButton... buttons) {
        final ButtonGroup buttonGroup = new ButtonGroup();
        for (final AbstractButton button : buttons) {
            buttonGroup.add(button);
        }
        return buttonGroup;
    }
}
