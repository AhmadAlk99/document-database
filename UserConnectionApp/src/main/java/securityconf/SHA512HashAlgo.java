package securityconf;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SHA512HashAlgo implements PasswordEncoder {

    private final Logger logger = Logger.getLogger("PasswordHashClass");

    public byte[] getSalt()  {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public byte[] getSaltedHash(String password, byte[] salt) {
        byte[] byteData = null;
        try {
            byteData = getHashedPassword(password, salt);
        } catch (Exception e){
            logError(e);
        }
        return byteData;
    }

    private byte[] getHashedPassword(String password, byte[] salt) throws NoSuchAlgorithmException {

        // Get a SHA-512 algorithm
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        // add the salt to the massageDigest and digest the password
        messageDigest.update(salt);
        byte[] byteData = messageDigest.digest(password.getBytes());
        messageDigest.reset();
        return byteData; // Return the Hashed Password
    }

    private void logError (Exception e){
        logger.log(Level.SEVERE,e.getMessage());
    }



}
