import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float price = 10.f;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many reductions?");
        int nbReduction = scan.nextInt();
        float[] reductions = new float[nbReduction];
        float prev = 1.f;
        for (int i = 0; i < nbReduction; i++) {
            //Check if reduction is given in descending order
            if (i > 0) {
                prev = reductions[i - 1];
            }
            do {
                System.out.println("Give me the " + (i + 1) + " reduction you want to apply");
                reductions[i] = scan.nextFloat();
            } while (prev < reductions[i]);
        }
        price = applyReductions(price, reductions);

        System.out.println("New price is : " + price);
    }

    private static float applyReductions(float price, float[] reductions) {
        for (float reduction : reductions) {
            price -= reduction * price;
        }
        return price;
    }
}
