import java.util.ArrayList;

public class Bug {//implements Contract {
    
    String name;
    String type;
    ArrayList<String> items;
    int x_position;
    int y_position;
    int size;
    int alertness;

    public Bug(String name, String type, int size, int alertness) {
        this.name = name;
        this.type = type;
        this.items = new ArrayList<String>();
        this.x_position = 0;
        this.y_position = 0;
        this.size = size;
        this.alertness = alertness;


    }

    
    void grab(String item) {
        //checks alertness to see if bu has enough energy to grab
    }
    String drop(String item) {
        //drops item if it is holding it 
        //Certain tye=pes can only hold certain items maybe?
    }
    void examine(String item) {
        //checks alertness to see if Bug has enough energy to examine
    }
    void use(String item) {
        //Checks alletness to see if bug has enough energy and checks if bug is holding an object
    }
    boolean walk(String direction) {
        //Check if alertness is high enough move x numbers in specified direction
    }
    boolean fly(int x, int y) {
        //Check if alertness is high enough increase or decease x and y
    }
    Number shrink() {
        //decrease size
    }
    Number grow() {
        //increase size
    }
    void rest() {
        //increase alertness if alertness reaches a certain point increase size(grow)

    }
    void undo() {
        //overloaded method
    }
}
