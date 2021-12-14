public class Operations {

    public static void resolveOperation() {
        String op = "(((a+b)*c-d)*e)*(k*(h+g)+j)+i";
        String decompose = getDecomposition(op,"","");
        System.out.println(decompose);
    }

    private static String getDecomposition(String lhs, String op, String rhs) {
        String[] split = splitOperation(lhs);
        if(split[1] == "")
            System.out.println("Ce n'est pas une opération mais un nombre");
        else
            getDecomposition(split[0], split[1], split[2]);

        //Tester si lhs est un nombre ou une composition
        //Si composition déterminer l'opérateur ppal et les coté gauche et droite
        //Et enfin appeler getDecomposition avec
        // en paramètre le coté gauche, l'opérateur et le coté droit trouvé

        //Refaire la meme chose avec rhs

        // Après ces 2 appels, normalement on a les valeurs numériques
        // des cotés gauche et droit => on peut leur appliquer l'opérateur
        return null;
    }

    private static String[] splitOperation(String operation) {
        String[] result = new String[3];

        return result;
    }

//    private static String getDecomposition(String op) {
//        System.out.println("Decomposition of " + op + " is :\n");
//        String decomposition = "";
//        decomposition += "a+b = J\n";
//        decomposition += "J*c = K\n";
//        decomposition += "K - d = L\n";
//        decomposition += "L*e = M\n";
//        decomposition += "h+g = O\n";
//        decomposition += "O*k = P\n";
//        decomposition += "P+j = Q\n";
//        decomposition += "Q*M = R\n";
//        decomposition += "R+i = S\n";
//        decomposition += "Solution of calculus is S\n";
//        return decomposition;
//    }
}
