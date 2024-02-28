package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordEncoder {

    private static final String ALGORITHM = "SHA-256";
    private static final int SALT_LENGTH = 16;

    public static String encodePassword(String password, String salt ) {
        String encodedPassword = null;
        
        if (salt == null) {
        	salt = generateSalt();
		}
      

        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);

            // Combina la contraseña y el salt antes de aplicar el hash
            String combined = password + salt;
            md.update(combined.getBytes());

            // Obtiene el hash y lo convierte a formato Base64
            byte[] hashedBytes = md.digest();
            encodedPassword = Base64.getEncoder().encodeToString(hashedBytes);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encodedPassword;
    }

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
