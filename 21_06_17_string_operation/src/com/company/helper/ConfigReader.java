package com.company.helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ConfigReader {

    private final Properties properties;

    public ConfigReader(String filePath) throws IOException {
        this.properties = new Properties();
        this.properties.load(new FileReader(filePath));
    }

    public List<String> getOperationsPaths() {
        String str = properties.getProperty("path");
        String[] strings = str.split("/");
        return Arrays.asList(strings);
    }
}
