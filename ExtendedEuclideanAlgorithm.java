import java.util.Scanner;

public class ExtendedEuclideanAlgorithm {

    public static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        } else {
            int[] result = extendedGCD(b, a % b);
            int gcd = result[0];
            int x1 = result[1];
            int y1 = result[2];

            int x = y1;
            int y = x1 - (a / b) * y1;

            return new int[]{gcd, x, y};
        }
    }

    public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        int a = scanner.nextInt();

        System.out.println("Enter number 2: "); 
        int b = scanner.nextInt();

        int[] result = extendedGCD(a, b);
        int gcd = result[0];
        int x = result[1];
        int y = result[2];

        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("Coefficients x and y are: " + x + " and " + y);
        System.out.println("Verification: " + a + " * " + x + " + " + b + " * " + y + " = " + (a * x + b * y));
    }
}
