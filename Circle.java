abstract class Shape {
    abstract void draw(); // No body – must be implemented by child
}

class Circle1 extends Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Circle{
    public static void main(String[] args) {
        Shape a1=new Circle1();
        a1.draw();
    }
}