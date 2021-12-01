package io.hacksy.aoc.v2021;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.Properties;
import java.io.InputStream;

public class PropertiesLoader {
    static public Properties getProperties() {
        Logger log = LoggerFactory.getLogger("PropertiesLoader");
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream fileInputStream = loader.getResourceAsStream("conf/app.properties")){
           prop.load(fileInputStream);
        } catch (Exception e) {
           log.error(e.getMessage(), e);
        }
        return prop;
    }
}
