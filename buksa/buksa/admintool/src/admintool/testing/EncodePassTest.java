package admintool.testing;

import admintool.encode.TripleDESPasswordCoder;

public class EncodePassTest {
    
    public static void main(String [] args) throws Exception {
        
        String seed = "HellHellHellHellHellHell";
        String pass = "qwertyiop[]";
        String salt = "dbondin";
        
        TripleDESPasswordCoder pc = new TripleDESPasswordCoder(seed);
        
        String enc = pc.encode(salt, pass);
        
        System.out.println("ENC = " + enc);
        
        String dec = pc.decode(enc);
        
        System.out.println("DEC = " + dec);
        
        return;
    }
    
}
