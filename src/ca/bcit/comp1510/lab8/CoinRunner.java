package ca.bcit.comp1510.lab8;

/**
 * Flips a coin for a given amount of times
 * and prints out the longest string of 
 * times the face was heads.
 * 
 * @author Nirajan Manandhar
 * @version 1.0
 *
 */
public class CoinRunner {
    
    /**
     * Runs the program.
     * @param args unused.
     */
    public static void main(String[] args) {
        Coin drachma = new Coin();
        int headCount = 1;
        int maxHead = 1;
        final int loopmax = 100;
        
        System.out.println("The coin is first at: " + drachma.toString());
        
        for (int i = 1; i <= loopmax; i++) {
            String prevResult = drachma.toString();
            drachma.flip();
            String result = drachma.toString();
            System.out.println(result);
            
            if (prevResult.equals(result) && result.equals("Heads")) {
                headCount++;
                if (headCount > maxHead) {
                    maxHead = headCount; 
                } 
            } else {
                headCount = 1;
            }
        }

        System.out.println("The longest run of  heads is " + maxHead);
    }
}
