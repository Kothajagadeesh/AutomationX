package utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Config {
    public static final String EXEC_TYPE = "env.executionType";
    public static final String BROWSER_TYPE = "browser.type";
    public static final String ENV_PROFILE = "environment.profile";
    public static final String HUB_URL = "hub.url";
    public static final String USER_NAME = "user.name";
    public static final String MOBILE = "mobile";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "LastName";
    public static final String EMAIL = "email";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String RATING = "rating";
    public static final String BASE_URL = "base_url";


    public static final String PASSWORD = "password";

    private static String configFile = "config.properties";

    private static Configuration configuration;

    /**
     * This method will load the content of the config.properties file
     *
     * @param fileName to load
     * @return
     */
    public static String loadAndGetResourceLocation(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(fileName).toString();
    }

    public static String getBrowserType() {
        try {
            configuration = new PropertiesConfiguration(loadAndGetResourceLocation(configFile));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(BROWSER_TYPE);
    }

    public static String getExecType() {
        try {
            configuration = new PropertiesConfiguration(loadAndGetResourceLocation(configFile));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(EXEC_TYPE);
    }

    public static String getEnvType() {
        try {
            configuration = new PropertiesConfiguration(loadAndGetResourceLocation(configFile));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(ENV_PROFILE);
    }

    public static String getHubUrl() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(HUB_URL);
    }

    public static String getUserName() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(USER_NAME);
    }

    public static String getMobileNo() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(MOBILE);
    }

    public static String getFirstName() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(FIRST_NAME);
    }

    public static String getLastName() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(LAST_NAME);
    }

    public static String getEmail() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(EMAIL);
    }

    public static String getPassword() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(PASSWORD);
    }

    public static String getCountry() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(COUNTRY);
    }

    public static String getCity() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(CITY);
    }

    public static String getRating() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(RATING);
    }

    public static String getUrl() {
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(BASE_URL);
    }
}
