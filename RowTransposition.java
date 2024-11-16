import java.util.*;

public class RowTransposition {
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        int textLength = text.length();
        int numColumns = key;
        int numRows = (int) Math.ceil((double) textLength / numColumns);
        char[][] grid = new char[numRows][numColumns];

        for (int i = 0; i < textLength; i++) {
            int row = i / numColumns;
            int col = i % numColumns;
            grid[row][col] = text.charAt(i);
        }

        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows; row++) {
                if (grid[row][col] != '\0') { 
                    result.append(grid[row][col]);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text to encrypt: "); //Hari
        String text = scanner.nextLine();
        int key = 3;

        String encrypted = encrypt(text, key);
        System.out.println("Encrypted: " + encrypted);
    }
}
