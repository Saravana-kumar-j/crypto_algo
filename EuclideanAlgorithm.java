import java.util.Scanner;

public class EuclideanAlgorithm {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; 
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        int a = scanner.nextInt();

        System.out.println("Enter number 2: "); 
        int b = scanner.nextInt();

        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
}
