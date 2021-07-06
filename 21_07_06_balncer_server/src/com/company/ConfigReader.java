package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties properties;

    ConfigReader(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(filePath));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
