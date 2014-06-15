package admintool.config;

import admintool.encode.PasswordCoderException;
import admintool.encode.TripleDESPasswordCoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ConfigurationHelper {
    
    public static final String PROPERTIES_FILE_COMMENT = "Buksa Admintool properties file";
    
    public static final Properties DEFAULT_PROPERTIES = new Properties();

    public static final Set ENCODED_PROPERTIES = new HashSet();
            
    public static final String USER_PROPERTIES_FILE_NAME = ".admintool.properties";
    
    private static final String USER_HOME = System.getProperty("user.home") +
            java.io.File.separator + USER_PROPERTIES_FILE_NAME;
    
    public static final String PROPERTY_DBNAME = "dbname";
    public static final String PROPERTY_DBPORT = "dbport";
    public static final String PROPERTY_DBUSER = "dbuser";
    public static final String PROPERTY_DBPASS = "dbpass";
    
    private static final String ENCODING_SEED = "NGFYDWLFKE766FJKEHUG1978";
    
    static {
        DEFAULT_PROPERTIES.setProperty(PROPERTY_DBNAME, "localhost");
        DEFAULT_PROPERTIES.setProperty(PROPERTY_DBPORT, "5432");
        DEFAULT_PROPERTIES.setProperty(PROPERTY_DBUSER, "buksa");
        DEFAULT_PROPERTIES.setProperty(PROPERTY_DBPASS, "");
    }
    
    static {
        ENCODED_PROPERTIES.add(PROPERTY_DBPASS);
    }
    
    public static Properties load() {
        
        FileInputStream userPropertiesFileInputStream;
        Properties props = new Properties();
        TripleDESPasswordCoder passwordCoder;

        try {
            userPropertiesFileInputStream = new FileInputStream(USER_PROPERTIES_FILE_NAME);
            props.load(userPropertiesFileInputStream);
        }
        catch(Exception ex) {
            /* Something went wrong. Greate default properties file here */
            save(DEFAULT_PROPERTIES);
            return DEFAULT_PROPERTIES;
        }
            
        /* Decode encoded loaded values */
        try {
            passwordCoder = new TripleDESPasswordCoder(ENCODING_SEED);
        }
        catch(PasswordCoderException ex) {
            passwordCoder = null;
        }
        
        for(String pk : props.stringPropertyNames()) {
            if(ENCODED_PROPERTIES.contains(pk)) {
                if(passwordCoder != null) {
                    try {
                        props.setProperty(pk, passwordCoder.decode(props.getProperty(pk)));
                    }
                    catch(PasswordCoderException ex) {
                        props.setProperty(pk, null);
                    }
                }
                else {
                    props.setProperty(pk, null);
                }
            }
        }
        
        return props;
    }
    
    public static void save(final Properties props) {
        
        Properties encProps = new Properties();
        TripleDESPasswordCoder passwordCoder;
        
        /* Encode values, which had to be encoded, copy others */
        try {
            passwordCoder = new TripleDESPasswordCoder(ENCODING_SEED);
        }
        catch(PasswordCoderException ex) {
            passwordCoder = null;
        }
        
        for(String pk : props.stringPropertyNames()) {
            if(ENCODED_PROPERTIES.contains(pk)) {
                if(passwordCoder != null) {
                    try {
                        encProps.setProperty(pk, passwordCoder.encode("==", props.getProperty(pk)));
                    }
                    catch(PasswordCoderException ex) {
                        encProps.setProperty(pk, null);
                    }
                }
                else {
                    encProps.setProperty(pk, null);
                }
            }
            else {
                encProps.setProperty(pk, props.getProperty(pk));
            }  
        }
        
        try {
            encProps.store(new FileOutputStream(USER_PROPERTIES_FILE_NAME), PROPERTIES_FILE_COMMENT);
        }
        catch(Exception ex) {
            // Ignore
        }
    }
}
