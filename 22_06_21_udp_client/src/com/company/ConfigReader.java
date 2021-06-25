package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader(String fileName) throws IOException {
        this.properties = new Properties();
        this.properties.load(new FileReader(fileName));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
