package ca.bcit.comp1510.lab8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Putting Cats in hotels.
 * @author Nirajan Manandhar
 * @version 1.0
 
 */
public class CatHotel {
    
    /**
     * Declares ArrayList guests.
     */
    private ArrayList<Cat> guests;
    
    /**
     * Declares String for hotel name.
     */
    private String hotelName;
    
    /**
     * Constructs a object called CatHotel.
     * @param hotelName a string.
     */
    CatHotel(String hotelName) {
        this.hotelName = hotelName;
        guests = new ArrayList<Cat>();
    }
    
    /**
     * Adds an item to the 
     * ArrayList.
     * @param cat a Cat object.
     */
    public void addCat(Cat cat) {
        guests.add(cat);
    }
    
    /**
     * Removes all item 
     * int the ArrayList.
     */
    public void removeAllGuests() {
        guests.clear();
    }
    
    /**
     * Returns the number of items
     * in the ArrayList.
     * @return an int.
     */
    public int guestCount() {
        return guests.size();
    }
    
    /**
     * Removes any ArrayList item.
     * 
     * @param number an int.
     * @return an int.
     */
    public int removeOldGuests(int number) {
        int counter = 0;
        Iterator<Cat> catIterator = guests.iterator();
        while (catIterator.hasNext()) {
            Cat temp = catIterator.next();
            if ((temp.getAge()) > number) {
                catIterator.remove();       
                counter++;
            } 
        }
        return counter;
    }
    
    /**
     * Prints out all the cats in the 
     * ArrayList.
     */
    public void printGuestList() {
        System.out.println("For hotel " + hotelName);
        for (Cat cat : guests) {
            System.out.println(cat);
        }
    }

}
