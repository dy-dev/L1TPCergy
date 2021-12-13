public class InterestRate {
    public static void placeMoney() {
        System.out.println("How much do you want to place");
        int money = Main.scan.nextInt();
        System.out.println("For how long");
        int years = Main.scan.nextInt();
        System.out.println("What is your interest rate");
        float rate = Main.scan.nextFloat();

        float howMuch = gain(money, years, rate);
        System.out.println("Congrats after " + years +" years, " +
                "you will have earned : " + howMuch +"$");
    }

    private static float gain(int money, int years, float rate) {
        return money * (1+rate*years);
    }
}
