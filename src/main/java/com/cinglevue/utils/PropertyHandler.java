package com.cinglevue.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Provides means of reading property files and get the runtime properties.
 */
public class PropertyHandler {

    /** The property file name. */
    private String propertyFileName;

    /** The property object. */
    private Properties props;

    /**
     * Instantiates a new property handler.
     * 
     * @param propertyFile
     *            the property file
     */
    public PropertyHandler(final String propertyFile) {
        propertyFileName = propertyFile;
        loadProperty();
    }


    /**
     * Gets the property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
    	
    	String value = props.getProperty(key);
    	return value;
    }
    
    /**
     * Loads the runtime property file.
     */
    private final void loadProperty() {

    	InputStream is = null;

        try {        	
        	is = this.getClass().getResourceAsStream(propertyFileName);
            props = new Properties();
            props.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    
}
