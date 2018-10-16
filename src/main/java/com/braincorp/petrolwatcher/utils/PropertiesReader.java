package com.braincorp.petrolwatcher.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final String KEY_FIREBASE_KEY_FILE = "firebase.key.file";
    private static final String KEY_FIREBASE_DATABASE_URL = "firebase.database.url";
    private static final String KEY_PREDICTIONS_FILE = "predictions.file";
    private static final String KEY_PRICES_DATA_SET_PATH = "prices.data.set.path";

    private Properties properties;

    public PropertiesReader() {
        Logger logger = LoggerFactory.getLogger(PropertiesReader.class);
        properties = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Properties file not found", e);
        }
    }

    public String getFirebaseKeyFile() {
        return properties.getProperty(KEY_FIREBASE_KEY_FILE);
    }

    public String getFirebaseDatabaseUrl() {
        return properties.getProperty(KEY_FIREBASE_DATABASE_URL);
    }

    public String getPredictionsFile() {
        return properties.getProperty(KEY_PREDICTIONS_FILE);
    }

    public String getPricesDataSetPath() {
        return properties.getProperty(KEY_PRICES_DATA_SET_PATH);
    }

}