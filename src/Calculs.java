import java.util.Random;

public class Calculs {
    static Random rand = new Random();

    public static void playGame() {
        System.out.println("Select Difficulty : \n" +
                "\t - 1 for easy" +
                "\t - 2 for medium" +
                "\t - 3 for hard");
        int diff = Main.scan.nextInt();
        int numberToGuess = 0;
        switch (diff){
            case 1 -> numberToGuess = calculation("+",500,900);
            case 2 -> numberToGuess = calculation("-",-300,300);
            case 3 -> numberToGuess =calculation("*",-100,100);
        }
        int prop = Main.scan.nextInt();
        if(prop == numberToGuess){
            System.out.println("Congrats");
        }else
            System.out.println("Fail it was " + numberToGuess);
    }

    private static int calculation(String operator, int minBound, int maxBound) {
        int resultat = 0;
        for (int i = 0; i < 4; i++) {
            int tmp = minBound + rand.nextInt(maxBound - minBound);
            System.out.println(tmp);
            switch (operator){
                case "+","-" -> resultat += tmp;
                case "*" -> resultat *= tmp;
            }
        }
        return resultat;
    }
}
