 class Marks {
    // Encapsulated data members
    private int mark1;
    private int mark2;
    private int mark3;

    public Marks(int x, int y, int z){
            mark1=x;
            mark2=y;
            mark3=z;
    }
    //set
    public void setMark1(int x) {
        mark1 = x;
    }

    public void setMark2(int y) {
        mark2 = y;
    }

    public void setMark3(int z) {
        mark3 = z;
    }

    // Get
    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public int getMark3() {
        return mark3;
    }
    public void display(){
        System.out.println("mark: " +mark1+ ","+mark2+","+mark3);
    }
}

public class Runner {
    public static void main(String[] args) {
//setting
        Marks s1 = new Marks(45,56,89);
        s1.display();
        s1.setMark1(85);
        s1.setMark2(90);
        s1.setMark3(78);

        // Getting and displaying
        System.out.println("Marks obtained:");
        System.out.println("Mark 1: " + s1.getMark1());
        System.out.println("Mark 2: " + s1.getMark2());
        System.out.println("Mark 3: " + s1.getMark3());
    }
}