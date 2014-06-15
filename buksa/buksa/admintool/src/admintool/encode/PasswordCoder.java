package admintool.encode;

/**
 * Common password coder interface
 */
public interface PasswordCoder {
    
    /**
     * Encodes password with salt
     * @param salt encoding salt
     * @param password password to encode
     * @return encoded password string
     */
    public String encode(String salt, String password) throws PasswordCoderException;
    
    /**
     * Encodes password
     * @param encpass encoded password string
     * @return decoded password
     */
    public String decode(String encpass) throws PasswordCoderException;
    
}
