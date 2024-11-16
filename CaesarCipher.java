import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        return cipher(text, shift);
    }

    public static String decrypt(String text, int shift) {
        return cipher(text, -shift);
    }

    private static String cipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift + 26) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter plain text: ");
        String text = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();

        String encrypted = encrypt(text, shift);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}
