public class EuclidAlgorithms {

    public static long GCD(long m, long n) throws ArithmeticException {
        long remainder = m % n;
        while (remainder != 0) {
            m = n;
            n = remainder;
            remainder = m % n;
        }
        return Math.abs(n);
    }

    public static long GCD_recursive(long m, long n) throws ArithmeticException {
        if (m % n == 0) return Math.abs(n);
        return GCD_recursive(n, m % n);
    }

    public static long[] extendedGCD(long m, long n) {
        long remainderFactorA = 0;
        long remainderFactorB = 1;
        long dividerFactorA = 1;
        long dividerFactorB = 0;
        
        long dividend = m;
        long commonGreatestDivider = n;

        long quotient = dividend / commonGreatestDivider;
        long remainder = dividend % commonGreatestDivider;

        long temp;

        while (remainder != 0) {
            dividend = commonGreatestDivider;
            commonGreatestDivider = remainder;

            temp = dividerFactorA;
            dividerFactorA = remainderFactorA;
            remainderFactorA = temp - quotient * remainderFactorA;

            temp = dividerFactorB;
            dividerFactorB = remainderFactorB;
            remainderFactorB = temp - quotient * remainderFactorB;

            quotient = dividend / commonGreatestDivider;
            remainder = dividend % commonGreatestDivider;
        }

        return new long[]{remainderFactorA, m, remainderFactorB, n, commonGreatestDivider};
    }
}
