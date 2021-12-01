package io.hacksy.aoc.v2021;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class App
{
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(App.class);
        Properties prop = PropertiesLoader.getProperties();
        logger.info(prop.getProperty("test.value"));
    }
}
