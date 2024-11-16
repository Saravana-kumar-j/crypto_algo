import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {

    public static String encrypt(String plainText, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);

        byte[] decryptedBytes = cipher.doFinal(decodedBytes);

        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

         System.out.print("Enter plain text: ");
           String plainText = scanner.nextLine();

           System.out.print("Enter key: ");
            String key = scanner.nextLine();  

            String encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Text (Base64): " + encryptedText);

            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
