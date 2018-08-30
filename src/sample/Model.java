package sample;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Model {
    public String generatePasswordHash(String passwordToHash){
        String generatedPasswordHash = null;
        try {
            MessageDigest messageDiget = MessageDigest.getInstance("MD5");
            messageDiget.update(passwordToHash.getBytes(StandardCharsets.UTF_8));
            // messageDiget.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = messageDiget.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPasswordHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPasswordHash;
    }}