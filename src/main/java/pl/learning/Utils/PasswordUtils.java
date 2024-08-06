package pl.learning.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtils {
    public static String generateSalt(){
        try {
            SecureRandom sr = SecureRandom.getInstanceStrong();
            byte[] salt = new byte[16];
            sr.nextBytes(salt);
            return Base64.getEncoder().encodeToString(salt);
        } catch(NoSuchAlgorithmException e){
            return "dcjf56do890eds12";
        }
    }
    public static String hashPassword(String password,String salt){
        try {
            byte[] bytesSalt = salt.getBytes();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytesSalt);
            byte[] hashPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashPassword);
        }catch (NoSuchAlgorithmException e){
            return null;
        }
    }
}
