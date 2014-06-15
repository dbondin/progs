package admintool.encode;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * PasswordCoder for 3DES
 */
public class TripleDESPasswordCoder implements PasswordCoder {
    
    public static final String SECRET_KEY_ALGORITHM = "TripleDES";
    
    public static final int SALT_SIZE = 2;
    
    public static final int MINIMUM_SEED_KEY_SIZE = 24;
    
    public static final String SALT_SEPARATOR = "$";
    
    /**
     * Constructor
     * @param seedKey initial seed key. Must be MINIMUM_SEED_KEY_SIZE chars long
     * as minimum (first MINIMUM_SEED_KEY_SIZE chars will be used as seed key)
     */
    public TripleDESPasswordCoder(String seedKey) throws PasswordCoderException {
        
        if(seedKey == null ||
                seedKey.length() < MINIMUM_SEED_KEY_SIZE) {
            throw new PasswordCoderException("sekKey must be not null and minimum MINIMUM_SEED_KEY_SIZE (" + 
                    MINIMUM_SEED_KEY_SIZE + ") chars long");
        }
        
        secretKeySpec = new SecretKeySpec(seedKey.substring(0, 24).getBytes(), SECRET_KEY_ALGORITHM);
        
        try {
            cipher = Cipher.getInstance(SECRET_KEY_ALGORITHM);
        }
        catch(Exception ex) {
            throw new PasswordCoderException(ex);
        }
        
    }

    public String encode(String salt, String password) throws PasswordCoderException{
        
        byte[] encBytes;
        String encString;
        
        if(salt == null || salt.length() < SALT_SIZE) {
            throw new PasswordCoderException("salt can't be null and must be as minimum as SALT_SIZE ("+
                    SALT_SIZE + ") chars long");
        }
        
        salt = salt.substring(0, SALT_SIZE);
        
        try {
            
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            encBytes = cipher.doFinal((salt + password).getBytes());

            encString = salt + SALT_SEPARATOR + new String(Base64.encodeBase64(encBytes));
        }
        catch(Exception ex) {
            throw new PasswordCoderException(ex);
        }
        
        return encString;
    }

    public String decode(String encpass) throws PasswordCoderException{

        String salt;
        String saltSeparator;
        String encStr;
        byte [] encBytes;
        String decStr;
        String decSalt;
        String decPass;
        
        if(encpass == null ||
                encpass.length() < SALT_SIZE + SALT_SEPARATOR.length()) {
            throw new PasswordCoderException("Bad encpass specified");
        }
        
        salt = encpass.substring(0, SALT_SIZE);
        saltSeparator = encpass.substring(SALT_SIZE, SALT_SIZE + SALT_SEPARATOR.length());
        encStr = encpass.substring(SALT_SIZE + SALT_SEPARATOR.length());
        
        if(!saltSeparator.equals(SALT_SEPARATOR)) {
            throw new PasswordCoderException("Bad encpass specified");
        }
        
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            
            encBytes = Base64.decodeBase64(encStr.getBytes());
            decStr = new String(cipher.doFinal(encBytes));
            
            if(decStr.length() < SALT_SIZE) {
                throw new PasswordCoderException("Decode error");
            }
            
            decSalt = decStr.substring(0, SALT_SIZE);
            decPass = decStr.substring(SALT_SIZE);
            
            if(!decSalt.equals(salt)) {
                throw new PasswordCoderException("Decode error");
            }
        }
        catch(Exception ex) {
            throw new PasswordCoderException(ex);
        }
        
        return decPass;
    }
    
    private final SecretKeySpec secretKeySpec;
    private final Cipher cipher;
}
