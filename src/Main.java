public class Main {

    public static void main(String[] args) {
        float price = 10.f;
        price -= 0.5*price;
        price -= 0.3*price;
        System.out.println("New price is : " + price);
    }
}
