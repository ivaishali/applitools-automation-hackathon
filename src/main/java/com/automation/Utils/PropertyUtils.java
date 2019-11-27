package com.automation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    static Properties prop = new Properties();

    public static void loadProperties() {
        try {
            // load config.properties file
            prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/resources/config.properties")));
            System.out.println(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return prop.getProperty(key);
    }
}
