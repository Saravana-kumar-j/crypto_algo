import java.util.Scanner;

public class FermatTheorem {

    public static long modExp(long a, long b, long m) {
        long result = 1;
        a = a % m;  
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % m;
            }
            a = (a * a) % m;
            b = b / 2;
        }
        return result;
    }

    public static boolean fermatsLittleTheorem(long a, long p) {
        if (p <= 1 || a % p == 0) {
            System.out.println("Invalid input: p must be a prime and a must not be divisible by p.");
            return false;
        }
        return modExp(a, p - 1, p) == 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        long a = scanner.nextLong();

        System.out.println("Enter number 2: "); 
        long p = scanner.nextLong();

        if (fermatsLittleTheorem(a, p)) {
            System.out.println(a + "^(" + (p - 1) + ") congruent to 1 (mod " + p + ")");
        } else {
            System.out.println(a + "^(" + (p - 1) + ") congruent to 1 (mod " + p + ") does not hold.");
        }
    }
}
