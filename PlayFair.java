import java.util.*;

public class PlayFair {
    private String key;
    private char[][] matrix;

    public PlayFair(String key) {
        this.key = key.toLowerCase();
        this.matrix = new char[5][5];
        createMatrix();
    }

    private void createMatrix() {
        StringBuilder processedKey = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : key.toCharArray()) {
            if (c >= 'a' && c <= 'z' && !seen.contains(c) && c != 'j') {
                seen.add(c);
                processedKey.append(c);
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!seen.contains(c) && c != 'j') {
                processedKey.append(c);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = processedKey.charAt(i * 5 + j);
            }
        }
    }

    private String formatMessage(String message) {
        message = message.toLowerCase().replace("j", "i");
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z') {
                formatted.append(c);
                if (i + 1 < message.length() && message.charAt(i + 1) == c) {
                    formatted.append('x');
                }
            }
        }
        if (formatted.length() % 2 != 0) {
            formatted.append('x');
        }
        return formatted.toString();
    }

    private int[] getPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public String encrypt(String message) {
        String formattedMessage = formatMessage(message);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < formattedMessage.length(); i += 2) {
            char first = formattedMessage.charAt(i);
            char second = formattedMessage.charAt(i + 1);

            int[] pos1 = getPosition(first);
            int[] pos2 = getPosition(second);

            if (pos1[0] == pos2[0]) { 
                result.append(matrix[pos1[0]][(pos1[1] + 1) % 5]);
                result.append(matrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) { 
                result.append(matrix[(pos1[0] + 1) % 5][pos1[1]]);
                result.append(matrix[(pos2[0] + 1) % 5][pos2[1]]);
            } else { 
                result.append(matrix[pos1[0]][pos2[1]]);
                result.append(matrix[pos2[0]][pos1[1]]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the key for Playfair cipher: ");
        String key = scanner.nextLine();

        System.out.println("Enter the message to encrypt: ");
        String message = scanner.nextLine();

        PlayFair playfairCipher = new PlayFair(key);

        String encryptedMessage = playfairCipher.encrypt(message);

        System.out.println("Encrypted Message: " + encryptedMessage);

        scanner.close();
    }
}
