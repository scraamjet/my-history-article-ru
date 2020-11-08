package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class PasswordHashCodeService {
    String passwordHashCode(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(String.format("%02X",b));
        }
        return stringBuilder.toString();
    }
}
