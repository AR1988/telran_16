package com.company.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    Properties properties;

    public ConfigReader(String propPath) throws IOException {
        this.properties = new Properties();
        this.properties.load(new FileReader(propPath));
    }

    public String getProp(String propName) {
        return properties.getProperty(propName);
    }
}
