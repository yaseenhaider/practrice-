
class Computer {
    int wordSize, memorySize, storageSize, speed;

    Computer() {
        wordSize = 0;
        memorySize = 0;
        storageSize = 0;
        speed = 0;
    }


    Computer(int wordSize, int memorySize, int storageSize, int speed) {
        this.wordSize = wordSize;
        this.memorySize = memorySize;
        this.storageSize = storageSize;
        this.speed = speed;
    }


    void display() {
        System.out.println("Word Size: " + wordSize + " bits");
        System.out.println("Memory Size: " + memorySize + " MB");
        System.out.println("Storage Size: " + storageSize + " MB");
        System.out.println("Speed: " + speed + " MHz");
    }
}


class Laptop extends Computer {
    double length, width, height, weight;

    Laptop() {
        super();  // Calls Computer default constructor
        length = width = height = weight = 0;
    }


    Laptop(int wordSize, int memorySize, int storageSize, int speed, double length, double width, double height, double weight) {
        super(wordSize, memorySize, storageSize, speed);
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }


    void display() {
        super.display();  // Call display() from Computer
        System.out.println("Length: " + length + " inches");
        System.out.println("Width: " + width + " inches");
        System.out.println("Height: " + height + " inches");
        System.out.println("Weight: " + weight + " kg");
    }
}

public class Task3 {
    public static void main(String[] args) {

        Computer myComputer = new Computer(64, 8000, 512000, 3200);


        Laptop myLaptop = new Laptop(64, 16000, 1024000, 3500, 15.6, 10.2, 0.7, 2.5);


        System.out.println("Computer Details:");
        myComputer.display();

      
        System.out.println("\nLaptop Details:");
        myLaptop.display();
    }
}
