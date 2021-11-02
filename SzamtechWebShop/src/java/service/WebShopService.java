package service;

public class WebShopService {
    
    private static String encrypt(String password){
        String encryptedPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        return encryptedPassword;
    }
}
