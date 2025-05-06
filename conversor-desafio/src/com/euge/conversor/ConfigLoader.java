package com.euge.conversor;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader()
                // ruta donde se encuntra el archivo con variables de entorno
                .getResourceAsStream("com/euge/conversor/config.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar config.properties");
            } else {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
