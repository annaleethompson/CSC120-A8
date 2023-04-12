/** 
 * Filename: Bug.java
 * Decription: Bug class implamenting Contract. Contains functions grab(), drop(), examine(), use(), walk(), fly(), shrink(), grow(), rest(), and undo(). 
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A8: Promises, Promises...
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: April 11, 2023
 */

 /**Imports ArrayList from the java.util package */
import java.util.ArrayList;

/**Bug Class */
public class Bug implements Contract {
    
    /**Stores strings for the name and type of the bug, and integers for the x_positon, y_position, size, and energy. Also stores an ArrayList for all the items that the bug is holding.  */
    String name;
    String type;
    ArrayList<String> items;
    int x_position;
    int y_position;
    int size;
    int energy;

    /**Constructor */ 
    public Bug(String name, String type) {
        this.name = name;
        this.type = type;
        this.items = new ArrayList<String>();
        this.x_position = 0;
        this.y_position = 0;
        this.size = 1;
        this.energy = 20;
    }
    
    /**Manipulator to grab an item by adding it to the items arraylist if the bug has enough energy and can hold another object. Reduces the bugs energy if it can grab the item. 
     * @param item item to be grabbed (item to be added to the items ArrayList)
     */
    public void grab(String item) {
        if (this.energy <2) {
            throw new RuntimeException("Sorry, " + this.name +" doesn't have enough energy to grab " + item);
        }
        if (this.items.size() ==2) {
            throw new RuntimeException("Sorry, " + this.name +" cannot hold any more items");
        }
        if (this.energy >=2 && this.items.size() < 2){
            items.add(item);
            this.energy-=2;
            System.out.println(this.name + " grabbed " + item);
        }
    }

    /**Manipulator to drop an item by removing it from the items arraylist if the bug is holding the item. 
     * @param item item to be dropped (item to be removed from the items Arraylist)
     */
    public String drop(String item) {
        if (this.items.size() ==0) {
            throw new RuntimeException("Sorry, " + this.name +" isn't holding any items");
        }
        if (!this.items.contains(item)) {
            throw new RuntimeException("Sorry, " +this.name + " isn't holding " + item);
        }
        else {
            this.items.remove(item);
            System.out.println(this.name + " dropped " +item);
            return item;
        }
    }

    /**Function that examines an item if the bug has enough energy. Reduces the bugs energy if it can examine the item. 
     * @param item item to be examined
     */
    public void examine(String item) {
        if (this.energy <1) {
            throw new RuntimeException("Sorry, " + this.name +" doesn't have enough energy to examine " + item);
        }
        if (this.energy >=1) {
            System.out.println("...Currently examining "+item+"...");
            this.energy -=1;
            System.out.println(this.name +" succesfully examined "+item);
        }
    }

    /**Function that uses an item if the bug has enough energy. If the bug is already holding the item it will automatically use the item otherwise it will grab() the item, use it, and then drop() it.
     * @param item item to be "used"
     */
    public void use(String item) {
        if (this.energy <5) {
            throw new RuntimeException("Sorry, " + this.name +" doesn't have enough energy to use " + item);
        }
        if (this.energy >=5 && !this.items.contains(item)) {
            this.grab(item);
            this.energy-=3;
            System.out.println("...Currently using "+item+"...");
            this.drop(item);
            System.out.println(this.name +" succesfully used "+item);
        }
        if (this.energy>=5 && this.items.contains(item)) {
            this.energy-=3;
            System.out.println("...Currently using "+item+"...");
            System.out.println(this.name +" succesfully used "+item);
        }
    }

    /**Manipulator that walks the bug 10 inches in a specified direction if the bug has enough energy and a valid direction was entered. 
     * @param direction the direction that the bug is to walk in (North, East, South, or West)
     * @return boolean describing whether the bug was able to walk.
     */
    public boolean walk(String direction) {
        if (this.energy <5) {
            throw new RuntimeException("Sorry, " + this.name +" doesn't have enough energy to walk");
        }
        if (direction!= "North" && direction!="South" && direction!="East" && direction!="West") {
            throw new RuntimeException("Not a valid direction");
        }
        if (this.energy >=5) {
            if (direction=="North") {
                System.out.println("...Currently Walking...");
                this.y_position+=10; 
                this.energy -=5;
                System.out.println(this.name + " walked 10 inches " + direction);
                return true;
            }
            if (direction == "South") {
                System.out.println("...Currently Walking...");
                this.y_position-=10; 
                this.energy -=5;
                System.out.println(this.name + " walked 10 inches " + direction);
                return true;
            }
            if (direction == "East") {
                System.out.println("...Currently Walking...");
                this.x_position+=10;
                this.energy -=5; 
                System.out.println(this.name + " walked 10 inches " + direction);
                return true;
            }
            if (direction == "West") {
                System.out.println("...Currently Walking...");
                this.y_position-=10;
                this.energy -=5; 
                System.out.println(this.name + " walked 10 inches " + direction);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**Manipulator that flys the Bug in the specified x and y directions if it has enough energy. Reduces the bugs energy if it can fly.
     * @param x the number of distance units the bug wants to fly in the x (East/West) direction
     * @param y the number of distance units the bug wants to fly in the y (North/South) direction.
     * @return boolean describing whether the bug was able to fly.
     */
    public boolean fly(int x, int y) {
        if (this.energy <10) {
            throw new RuntimeException("Sorry, " + this.name +" doesn't have enough energy to fly");
        }
        if (this.energy >=10) {
            System.out.println("...Currently Flying...");
            this.x_position +=x;
            this.y_position+=y;
            this.energy-=10; 
            System.out.println("Flight Complete!");
            return true;
        }
        else{
            return false;
        }
    }

    /**Manipulator that will decrease the size of the bug if it is already not the smallest size possible.
     * @return number describing the bugs size (1-10).
     */
    public Number shrink() {
        if (this.size ==1) {
            throw new RuntimeException(this.name + " cannot shrink anymore!");
        }
        else {
            this.size -=1;
            System.out.println(this.name + " shrunk to size "+ this.size);
        }
        return this.size;
    }

    /**Manipulator that will increase the size of the bug if it is not at the max size and has enough energy to grow. Decreases the bug's energy if it can grow. 
     *@return number describing the bugs size (1-10).
     */
    public Number grow() {
        if (this.size ==10) {
            throw new RuntimeException(this.name +" cannot grow anymore!");
        }
        if (this.energy < 30) {
            throw new RuntimeException("Sorry, " + this.name +" does not have enough energy to grow");
        }
        if (this.energy >= 30) {
            this.energy -=30;
            this.size +=1;
            System.out.println(this.name + " grew to size " + this.size);
        }
        return this.size;
    }

    /**Manipulator that will increase the bugs energy by ten and will call on the grow function if the energy reaches a certain level (50) */
    public void rest() {
        this.energy+=10;
        if (this.energy == 50 || this.energy >50) {
            this.grow();
        }
    }

    /**Manipulator that will undo all of the Bug's actions by resetting all of the Bugs parameters */
    public void undo() {
        this.items.clear();
        this.x_position=0;
        this.y_position=0;
        this.size = 1;
        this.energy = 20;
    }

    public static void main(String[] args) {
        Bug Egg = new Bug("Egg", "Butterfly");
        System.out.println(Egg.energy);
        //Egg.grab("Yoke");
        //System.out.println(Egg.energy);
        //Egg.drop("Yoke");
        //System.out.println(Egg.energy);
        //Egg.grab("Shell");
        //Egg.grab("Egg White");
        //Egg.examine("Yoke");
        //Egg.use("Yoke");
        //Egg.walk("North");
        //Egg.fly(10, 11);
        //Egg.rest();
        //System.out.println(Egg.x_position);
        //System.out.println(Egg.y_position);
        //Egg.fly(1,2);
        //Egg.shrink();
        //System.out.println(Egg.size);
        //Egg.shrink();
        //Egg.grow();
        //Egg.rest();
        //Egg.rest();
        //Egg.rest();
        //System.out.println(Egg.size);
        //System.out.println(Egg.energy);
        //Egg.undo();
        //System.out.println(Egg.size);
        //System.out.println(Egg.energy);
        //System.out.println(Egg.x_position);
        //System.out.println(Egg.y_position);
    }
}
