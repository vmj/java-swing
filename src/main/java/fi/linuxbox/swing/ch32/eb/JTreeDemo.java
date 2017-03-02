package fi.linuxbox.swing.ch32.eb;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;

import static java.awt.BorderLayout.SOUTH;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JTreeDemo {
    public JTreeDemo() {
        final JFrame frame = new JFrame("JTree Demo");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
        final DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        final DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
        final DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
        final DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
        final DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
        final DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
        final DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");

        top.add(a);
        a.add(a1);
        a.add(a2);
        top.add(b);
        b.add(b1);
        b.add(b2);
        b.add(b3);

        final JTree tree = new JTree(top);
        final JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane);

        final JLabel label = new JLabel();
        frame.add(label, SOUTH);

        tree.addTreeSelectionListener(e -> label.setText("Selection is: " + e.getPath()));

        frame.setVisible(true);
    }
}
