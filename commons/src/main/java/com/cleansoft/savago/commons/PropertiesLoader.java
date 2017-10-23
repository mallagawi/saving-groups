package com.cleansoft.savago.commons;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    private String propertiesFile;

    public PropertiesLoader(String propertiesFile) {

        if (StringUtils.isBlank(propertiesFile))
            throw new InvalidPropertiesFile();

        String[] fileNameParts = propertiesFile.split("\\.");
        if (fileNameParts.length != 2 || !"properties".equals(fileNameParts[1]))
            throw new InvalidPropertiesFile();
        this.propertiesFile = propertiesFile;
    }

    public String getValueOf(String key) {
        Properties properties = new Properties();
        try {

            properties.load(this.getClass().getClassLoader().getResourceAsStream(propertiesFile));
            return String.valueOf(properties.get(key));
        } catch (Exception e) {
            throw new LoadingPropertiesException(e);
        }
    }

    public Map<String, String> getValuesOf(List<String> keys) {
        Map<String, String> propertiesMap = new HashMap<>();
        for (String key : keys) {
            propertiesMap.put(key, getValueOf(key));
        }
        return propertiesMap;
    }

    public static class InvalidPropertiesFile extends RuntimeException {
    }

    public static class LoadingPropertiesException extends RuntimeException {
        public LoadingPropertiesException(Exception e) {
            super(e);
        }
    }
}
