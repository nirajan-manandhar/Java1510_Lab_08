package ca.bcit.comp1510.lab8;

import java.util.Random;

/**
 * Tests the Cat and Cathotel.
 * @author Nirajan Manandhar
 * @version 1.0
 *
 */
public class CatDriver {
    
    /**
     * Drives the program.
     * @param args unused.
     */
    public static void main(String[] args) {
        Random rand = new Random();
        final int maxAge = 23;
        final int ageLimit = 15;
        CatHotel hotel1 = new CatHotel("The Litterbox");
        Cat kitty = new Cat("", rand.nextInt(maxAge));
        final int max = 10;
        
        for (int i = 1; i <= max; i++) {
            kitty = new Cat("", rand.nextInt(maxAge));
            hotel1.addCat(kitty);
        }
        System.out.println("---");
        System.out.println(hotel1.guestCount());
        System.out.println(hotel1.removeOldGuests(ageLimit));
        hotel1.printGuestList();
        
          
    }

}
