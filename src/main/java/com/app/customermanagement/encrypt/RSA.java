package com.app.customermanagement.encrypt;

import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSA {

    // Hàm để tạo cặp khóa RSA
    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Độ dài khóa 2048 bit
        return keyPairGenerator.generateKeyPair();
    }

    // Hàm để mã hóa dữ liệu với khóa công khai
    public static String encryptData(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // Trả về dữ liệu đã mã hóa dưới dạng chuỗi Base64
    }

    // Hàm để giải mã dữ liệu với khóa riêng
    public static String decryptData(String encryptedData, PrivateKey privateKey) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes); // Trả về dữ liệu đã giải mã dưới dạng chuỗi
    }

    public static void main(String[] args) {
        try {
            // Tạo cặp khóa RSA
            KeyPair keyPair = generateRSAKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Dữ liệu cần mã hóa
            String originalData = "tnd";

            // Mã hóa dữ liệu với khóa công khai
            String encryptedData = encryptData(originalData, publicKey);
            System.out.println("Encrypted Data: " + encryptedData);

            // Giải mã dữ liệu với khóa riêng
            String decryptedData = decryptData(encryptedData, privateKey);
            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
