import java.util.Scanner;

public class VigenereCipher {
    
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String text, String key) {
        return cipher(text, key, true);
    }

    public static String decrypt(String text, String key) {
        return cipher(text, key, false);
    }

    private static String cipher(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();

        int keyIndex = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int textCharIndex = ALPHABET.indexOf(c);
                int keyCharIndex = ALPHABET.indexOf(key.charAt(keyIndex % key.length()));
                
                int cipherIndex = encrypt ? 
                    (textCharIndex + keyCharIndex) % 26 : 
                    (textCharIndex - keyCharIndex + 26) % 26;

                result.append(ALPHABET.charAt(cipherIndex));
                keyIndex++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter plain text: ");
        String text = scanner.nextLine();

        System.out.print("Enter key: ");
        String key = scanner.nextLine();

        String encrypted = encrypt(text, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}
