import java.util.Scanner;

public class ChineseRemainderTheorem {

    public static int extendedGCD(int a, int b, int[] xy) {
        if (a == 0) {
            xy[0] = 0;
            xy[1] = 1;
            return b;
        }
        int[] xy1 = new int[2];
        int gcd = extendedGCD(b % a, a, xy1);
        xy[0] = xy1[1] - (b / a) * xy1[0];
        xy[1] = xy1[0];
        return gcd;
    }

    public static int modInverse(int a, int m) {
        int[] xy = new int[2];
        int gcd = extendedGCD(a, m, xy);
        if (gcd != 1) {
            System.out.println("Modular inverse does not exist.");
            return -1;
        }
        return (xy[0] % m + m) % m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a1: ");
        int a1 = scanner.nextInt();
        System.out.println("Enter a2: ");
        int a2 = scanner.nextInt();
        System.out.println("Enter a3: ");
        int a3 = scanner.nextInt();

        System.out.println("Enter m1: ");
        int m1 = scanner.nextInt();
        System.out.println("Enter m2: ");
        int m2 = scanner.nextInt();
        System.out.println("Enter m3: ");
        int m3 = scanner.nextInt();

        int M = m1 * m2 * m3;

        int M1 = M / m1;
        int M2 = M / m2;
        int M3 = M / m3;

        int x1 = modInverse(M1, m1); 
        int x2 = modInverse(M2, m2);
        int x3 = modInverse(M3, m3);

        if (x1 == -1 || x2 == -1 || x3 == -1) {
            System.out.println("Error in finding modular inverse.");
            return;
        }

        int x = (M1 * x1 * a1 + M2 * x2 * a2 + M3 * x3 * a3) % M;

        if (x < 0) {
            x += M;
        }

        System.out.println("The solution is: " + x);

        scanner.close();
    }
}
