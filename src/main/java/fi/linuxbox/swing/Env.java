package fi.linuxbox.swing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class Env {
    private static Logger log = LoggerFactory.getLogger(Env.class);

    public static void logEnvInfo() {
        logOSInfo();
        logJavaInfo();
        logLAFInfo();
    }

    public static boolean isOSX() {
        // https://developer.apple.com/library/content/technotes/tn2002/tn2110.html
        return System.getProperty("os.name").contains("OS X");
    }

    private static void logOSInfo() {
        log.info("OS name: " + System.getProperty("os.name") + ": " + (isOSX() ? "seems to be mac" : "not a mac"));
        log.info("OS version: " + System.getProperty("os.version"));
    }

    private static void logJavaInfo() {
        log.info("Java version: " + System.getProperty("java.version"));
        log.info("Java runtime version: " + System.getProperty("java.runtime.version"));
    }

    private static void logLAFInfo() {
        final LookAndFeel laf = UIManager.getLookAndFeel();
        log.info("Using LAF: " + laf.getName() + ": " + laf.getDescription());
        log.info("Other available LAFs are:");
        for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (!laf.getName().equals(info.getName()))
                log.info(" - " + info.getName() + ": " + info.getClassName());
        }

    }
}
