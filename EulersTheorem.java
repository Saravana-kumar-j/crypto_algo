import java.util.Scanner;

public class EulersTheorem {

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

    public static long eulerTotient(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    public static boolean eulersTheorem(long a, long n) {
        if (gcd(a, n) != 1) {
            System.out.println("a and n must be coprime.");
            return false;
        }
        long phiN = eulerTotient(n);
        return modExp(a, phiN, n) == 1;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        long a = scanner.nextLong();

        System.out.println("Enter number 2: "); 
        long n = scanner.nextLong();

        if (eulersTheorem(a, n)) {
            System.out.println(a + "^φ(" + n + ") ≡ 1 (mod " + n + ")");
        } else {
            System.out.println(a + "^φ(" + n + ") ≡ 1 (mod " + n + ") does not hold.");
        }
    }
}
