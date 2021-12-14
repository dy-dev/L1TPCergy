import java.util.ArrayList;
import java.util.List;

public class Prime {
    public static void getNumbers() {
        System.out.println("Limite Max?");
        long limitMax = Main.scan.nextLong();

        long startTime = System.nanoTime();
        List<Long> numbers = getBrutalArray(limitMax);
        long endTime = System.nanoTime();


       // System.out.println(numbers);
        System.out.println("Brutal All those numbers where found in " +
                (endTime - startTime) / Math.pow(10, 9) + " seconds");

        startTime = System.nanoTime();
        numbers = cribleEratostene(limitMax);
        numbers.removeIf(n->n==0);
        //System.out.println(numbers);
        endTime = System.nanoTime();
        System.out.println("Eratostene All those numbers where found in " +
                (endTime - startTime) / Math.pow(10, 9) + " seconds");

        startTime = System.nanoTime();
        numbers = getSmartArray(limitMax);
        endTime = System.nanoTime();
        System.out.println("Smart those numbers where found in " +
                (endTime - startTime) / Math.pow(10, 9) + " seconds");
    }

    private static List<Long> getSmartArray(long limitMax) {
        List<Long> primeNumbers = new ArrayList<>();
        primeNumbers.add(2L);
        for (long i = 3; i < limitMax; i += 2) {
            if (isPrimeOptim(i))
                primeNumbers.add(i);
        }
        return primeNumbers;
    }

    private static boolean isPrimeOptim(long n) {
        for (long j = 3; j * j < n + 2; j += 2) {
            if (n % j == 0)
                return false;
        }
        return true;
    }

    private static List<Long> cribleEratostene(long limitMax) {
        List<Long> primeNumbers = new ArrayList<>();
        for (long i = 0; i < limitMax; i++) {
            if (i > 2 && i % 2 == 0)
                primeNumbers.add(0L);
            else
                primeNumbers.add(i);
        }
        primeNumbers.set(1,0L);

        int index = 0;
        for (long i = 5; i < limitMax; i++) {
            Long nbToCheck = primeNumbers.get((int) i);
            if (nbToCheck > 0) {
                long k = isPrime(nbToCheck) ? 3 : 1;
                long val = k * nbToCheck;
                while (val < limitMax) {
                    final long tmp = val;
                    primeNumbers.set((int) val, 0L);
                    k += 2;
                    val = k * nbToCheck;
                }
            }
        }
        return primeNumbers;
    }

    private static List<Long> getBrutalArray(long limitMax) {
        List<Long> primeNumbers = new ArrayList<>();
        primeNumbers.add(2L);
        for (long i = 3; i < limitMax; i++) {
            if (isPrime(i))
                primeNumbers.add(i);
        }
        return primeNumbers;
    }

    private static boolean isPrime(long i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }
}
