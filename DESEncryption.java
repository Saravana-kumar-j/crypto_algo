import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESEncryption {

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        return keyGenerator.generateKey();
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    public static void main(String[] args) {
        try {
            SecretKey secretKey = generateKey();

           Scanner scanner = new Scanner(System.in);

         System.out.print("Enter plain text: ");
           String originalData = scanner.nextLine();

            String encryptedData = encrypt(originalData, secretKey);
            System.out.println("Encrypted Data: " + encryptedData);

            String decryptedData = decrypt(encryptedData, secretKey);
            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
