import java.util.Scanner;

class HillCipher {

    static void getKeyMatrix(String key, int keyMatrix[][]) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    static void encrypt(int cipherMatrix[][], int keyMatrix[][], int messageVector[][]) {
        int x, i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;

                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];
                }

                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }

    static void HillCipher(String message, String key) {
        int[][] keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);

        int[][] messageVector = new int[3][1];

        for (int i = 0; i < 3; i++) {
            messageVector[i][0] = (message.charAt(i)) % 65;
        }

        int[][] cipherMatrix = new int[3][1];

        encrypt(cipherMatrix, keyMatrix, messageVector);

        StringBuilder CipherText = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            CipherText.append((char)(cipherMatrix[i][0] + 65));
        }

        System.out.println("Ciphertext: " + CipherText.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the message (3 characters): ");
        String message = scanner.nextLine().toUpperCase();

        if (message.length() != 3) {
            System.out.println("Message must be exactly 3 characters.");
            return;
        }

        System.out.println("Enter the key (9 characters): ");
        String key = scanner.nextLine().toUpperCase();

        if (key.length() != 9) {
            System.out.println("Key must be exactly 9 characters.");
            return;
        }
        HillCipher(message, key);

        scanner.close();
    }
}
