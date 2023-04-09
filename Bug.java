import java.util.ArrayList;

public class Bug { //implements Contract {
    
    String name;
    String type;
    ArrayList<String> items;
    int x_position;
    int y_position;
    int size;
    int energy;

    public Bug(String name, String type) {
        this.name = name;
        this.type = type;
        this.items = new ArrayList<String>();
        this.x_position = 0;
        this.y_position = 0;
        this.size = 1;
        this.energy = 20;
    }
    
    void grab(String item) {
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
    String drop(String item) {
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
    void examine(String item) {
        if (this.energy <1) {
            throw new RuntimeException("Sorry, " + this.name +" doesn't have enough energy to examine " + item);
        }
        if (this.energy >=1) {
            System.out.println("...Currently examining "+item+"...");
            this.energy -=1;
            System.out.println(this.name +" succesfully examined "+item);
        }

    }
    void use(String item) {
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
    boolean walk(String direction) {
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
    boolean fly(int x, int y) {
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
    Number shrink() {
        if (this.size ==1) {
            throw new RuntimeException(this.name + " cannot shrink anymore!");
        }
        else {
            this.size -=1;
            System.out.println(this.name + " shrunk to size "+ this.size);
        }
        return this.size;
    }
    Number grow() {
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
    void rest() {
        this.energy+=10;
        if (this.energy == 50 || this.energy >50) {
            this.grow();
        }

    }
    void undo() {
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
