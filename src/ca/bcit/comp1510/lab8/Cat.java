package ca.bcit.comp1510.lab8;

/**
 * Runs a cat hotel.
 * @author Nirajan Manandhar
 * @version 1.0
 *
 */
public class Cat {
    
    /**
     * Declares string name.
     */
    private final String name;
    
    /**
     * Declares int age.
     */
    private int age;
    
    /**
     * Constructs an object called Cat.
     * @param name a String.
     * @param age an Int.
     */
    Cat(String name, int age) {
        
        if (name.equals("")) {
            this.name = "Cleo";
        } else {
            this.name = name;
        }
        
        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    /**
     * Gets the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the age.
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

  
    @Override
    public String toString() {
        return "Cat [name=" + name + ", age=" + age + "]";
    }

}
