import java.util.Scanner;

public class Loan {
    public static void takeLoan() {
        System.out.println("How much do you want to borrow");
        int money = Main.scan.nextInt();
        System.out.println("What is the interest rate");
        float rate = Main.scan.nextFloat();
        System.out.println("For how long");
        int years = Main.scan.nextInt();

        float cost = calculateLoan(money, rate, years);
        System.out.println("The cost of your loan is : " +cost);
    }

    private static float calculateLoan(int money, float rate, int years) {
        float monthlyRate = rate / 12.f;
        float mensualities = money*monthlyRate;
        float denomValue = (float) Math.pow(1+monthlyRate,-12*years);
        mensualities /= (1-denomValue);
        System.out.println("Your mensualities will be : " + mensualities);
        float totalPriceLoan = 12*years*mensualities;
        float costLoan = totalPriceLoan - money;
        return costLoan;
    }
}
