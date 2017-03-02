package fi.linuxbox.swing;

import fi.linuxbox.swing.ch31.e1.SwingDemo;
import fi.linuxbox.swing.ch31.e2.EventDemo;
import fi.linuxbox.swing.ch31.e4.PaintDemo;
import fi.linuxbox.swing.ch32.e1.JLabelDemo;
import fi.linuxbox.swing.ch32.e2.JTextFieldDemo;
import fi.linuxbox.swing.ch32.e3.JButtonDemo;
import fi.linuxbox.swing.ch32.e4.JToggleButtonDemo;
import fi.linuxbox.swing.ch32.e5.JCheckBoxDemo;
import fi.linuxbox.swing.ch32.e6.JRadioButtonDemo;
import fi.linuxbox.swing.ch32.e7.JTabbedPaneDemo;
import fi.linuxbox.swing.ch32.e8.JScrollPaneDemo;
import fi.linuxbox.swing.ch32.e9.JListDemo;
import fi.linuxbox.swing.ch32.ea.JComboBoxDemo;
import fi.linuxbox.swing.ch32.eb.JTreeDemo;
import fi.linuxbox.swing.ch32.ec.JTableDemo;
import fi.linuxbox.swing.ch33.MenuDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class SwingMain {
    private static Logger log = LoggerFactory.getLogger(SwingMain.class);

    public static void main(String... args) throws Exception {
        log.info("Starting main: thread " + Thread.currentThread().getId());
        Env.logEnvInfo();
        if (Env.isOSX()) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            // Does not work!
            // The "SwingMain" comes from the main class name
            //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Swing Demo");
        }

        SwingUtilities.invokeLater(() -> {
            log.info("Running in dispatcher thread " + Thread.currentThread().getId());
            final String demo = args != null && args.length > 0 ? args[0].toLowerCase() : "";
            switch (demo) {
                case "ch31.e1": new SwingDemo(); break;
                case "ch31.e2": new EventDemo(); break;
                case "ch31.e4": new PaintDemo(); break;
                case "ch32.e1": new JLabelDemo(); break;
                case "ch32.e2": new JTextFieldDemo(); break;
                case "ch32.e3": new JButtonDemo(); break;
                case "ch32.e4": new JToggleButtonDemo(); break;
                case "ch32.e5": new JCheckBoxDemo(); break;
                case "ch32.e6": new JRadioButtonDemo(); break;
                case "ch32.e7": new JTabbedPaneDemo(); break;
                case "ch32.e8": new JScrollPaneDemo(); break;
                case "ch32.e9": new JListDemo(); break;
                case "ch32.ea": new JComboBoxDemo(); break;
                case "ch32.eb": new JTreeDemo(); break;
                case "ch32.ec": new JTableDemo(); break;
                default: new MenuDemo(); break;
            }
            log.info("UI constructed in thread " + Thread.currentThread().getId());
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Running shutdown hook in thread " + Thread.currentThread().getId());
            log.info("Done cleaning up in thread " + Thread.currentThread().getId());
        }));

        log.info("Exising main: thread " + Thread.currentThread().getId());
    }
}
