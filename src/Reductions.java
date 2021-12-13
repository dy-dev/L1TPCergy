import java.util.Scanner;

public class Reductions {
    private static String notEnoughChange = "You did not give enough money";
    public static void ReductionExercise() {
        float price = 182.26f;
        System.out.println("How many reductions?");
        int nbReduction = Main.scan.nextInt();
        float[] reductions = new float[nbReduction];
        float prev = 1.f;
        for (int i = 0; i < nbReduction; i++) {
            //Check if reduction is given in descending order
            if (i > 0) {
                prev = reductions[i - 1];
            }
            do {
                System.out.println("Give me the " + (i + 1) + " reduction you want to apply");
                reductions[i] = Main.scan.nextFloat();
            } while (prev < reductions[i]);
        }
        price = applyReductions(price, reductions);

        System.out.println("New price is : " + price);
        String change = "";
        do {
            System.out.println("Please give me the money");
            int nbBills = Main.scan.nextInt();
             change = checkNbBills(price, nbBills);
        }while(change.equals(notEnoughChange));
        System.out.println(change);
    }

    private static String checkNbBills(float price, int nbBills) {
        //First, check if is there enough bills
        if(nbBills * 20 < price){
            return notEnoughChange;
        }
        int[] changes = new int[]{50000,20000,10000,5000,2000, 1000,500,200,100,50,20,10,5,1};
        int priceInCents = (int) (price*100);
        String returnInfo = "I have to give you back : \n";
        for(int change : changes){
            int result = (int) (priceInCents/change);
            if(result > 0){
                priceInCents %= change;
                returnInfo += "\t - "+  result + " " + (float)change/100.f;
                if(change >=500)
                    returnInfo += " bills\n";
                else
                    returnInfo += " coins\n";
            }
        }
        return returnInfo;
    }

    private static float applyReductions(float price, float[] reductions) {
        for (float reduction : reductions) {
            price -= reduction * price;
        }
        return price;
    }

}
