package utils;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {

    //if we used properties.''' -> we need everytime we need a property to specify where are we geting this property from
    //insted we use System.getProperty() to scan all the properties we have in our project

    // Load Properties function to load all data exists on .properties files into system properties
    public static  Properties loadProperties(){
        try{
            Properties properties = new Properties();
            Collection<File> propertiesFiles;
            propertiesFiles = FileUtils.listFiles(
                    new File("src/main/resources"),
                    new String[]{"properties"},
                    true
            );
            propertiesFiles.forEach(file -> {
                try {
                    properties.load(FileUtils.openInputStream(file));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                properties.putAll(System.getProperties());
                System.getProperties().putAll(properties);
            });
            return properties;
        } catch (Exception e) {
            System.out.println("Error loading properties file");
            return null;
        }
    }

    public static String getProperty (String key){
        try{
            return System.getProperty(key);
        }catch (Exception e){
            System.out.println("Error getting property: " + key);
            return "";
        }
    }

}
