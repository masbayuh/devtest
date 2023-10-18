package org.example;

import java.util.Properties;

public class PropertiesUtil {
    private Properties progProp = new Properties();
    private static PropertiesUtil instance;

    private PropertiesUtil() {
    }

    public static PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    public Properties getProgProp() {
        return progProp;
    }

    public void setProgProp(Properties progProp) {
        this.progProp = progProp;
    }
}
