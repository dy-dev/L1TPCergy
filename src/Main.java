import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner scan;

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en","US","us"));
        scan = new Scanner(System.in);
        //Reductions.ReductionExercise();
//        Loan.takeLoan();
//        InterestRate.placeMoney();
//        Tierce.winningOdds();
        //Calculs.playGame();
        Prime.getNumbers();
    }

}
