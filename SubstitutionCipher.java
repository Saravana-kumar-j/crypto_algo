import java.util.Scanner;

public class SubstitutionCipher {
    
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String text, String substitutionAlphabet) {
        return cipher(text, substitutionAlphabet, false);
    }

    public static String decrypt(String text, String substitutionAlphabet) {
        return cipher(text, substitutionAlphabet, true);
    }

    private static String cipher(String text, String substitutionAlphabet, boolean decrypt) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = decrypt ? substitutionAlphabet.indexOf(c) : ALPHABET.indexOf(c);
                char newChar = decrypt ? ALPHABET.charAt(index) : substitutionAlphabet.charAt(index);
                result.append(newChar);
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

        System.out.print("Enter substitution alphabet (26 letters): "); 
        String substitutionAlphabet = scanner.nextLine().toUpperCase();

        if (substitutionAlphabet.length() != 26) {
            System.out.println("Error: Substitution alphabet must contain 26 letters.");
            return;
        }

        String encrypted = encrypt(text, substitutionAlphabet);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, substitutionAlphabet);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}
