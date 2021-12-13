public class Tierce {
    public static void winningOdds() {

        System.out.println("How many horses are running");
        int nbHorses = Main.scan.nextInt();
        System.out.println("How many horses are played");
        int nbHorsesPlayed = Main.scan.nextInt();

        long[] oddsBrutal = calculateBrutallTheOdds(nbHorses, nbHorsesPlayed);
        System.out.println("You have 1 chance over " + oddsBrutal[0] + " to find in disorder");
        System.out.println("You have 1 chance over " + oddsBrutal[1] + " to find in order");
        long[] oddsSmart = calculateSmartTheOdds(nbHorses, nbHorsesPlayed);
    }

    private static long[] calculateSmartTheOdds(int nbHorses, int nbHorsesPlayed) {
        long smartFactNumerateur = 1;
        long smartFactDeNumerateur = 1;
        for (int i = 0; i < nbHorsesPlayed; i++) {
            smartFactNumerateur *= (nbHorses-i);
            smartFactDeNumerateur *= (i+1);
        }
        long[] toReturn = new long[2];
        toReturn[0] = smartFactNumerateur;
        toReturn[1] = smartFactNumerateur/smartFactDeNumerateur;

        return toReturn;
    }

    private static long[] calculateBrutallTheOdds(int nbHorses, int nbHorsesPlayed) {
        long[] results = new long[2];
        results[0] = factoriel(nbHorses)/factoriel(nbHorses - nbHorsesPlayed);
        results[1] = factoriel(nbHorses)/(factoriel(nbHorsesPlayed) * factoriel(nbHorses - nbHorsesPlayed));
        return results;
    }

    private static long factoriel(long i) {
        //n! = n*    (n-1)*(n-2)*....*3*2*1 ===> n! = n* (n-1)!
        //(n-1)! =   (n-1)*(n-2)*....*3*2*1
        if( i <= 0) return 1;
        else return i * factoriel( i-1);
    }
}
