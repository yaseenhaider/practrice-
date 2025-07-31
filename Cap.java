class Circle2 {
    private int radius;

    public Circle2() {
        radius = 7;
    }
    public Circle2(int r) {
        radius = r;
    }
    public void setRadius(int r) {
        radius = r;
    }
    public int getRadius() {
        return radius;
    }
    public void display() {
        System.out.println("radius = " + radius);
    }
    public double CalculateCircumference() {
        double a = 3.14 * radius * radius;
        return a;
    }
}
public class Cap {
    public static void main(String args[]) {
        Circle2 c1 = new Circle2();
        c1.setRadius(5);
        System.out.println("Circumference of Circle 1 is: " + c1.CalculateCircumference());
        int r = c1.getRadius();
        Circle2 c2 = new Circle2(r);
        c2.setRadius(5);
        System.out.println("Circumference of Circle 2 is: " + c2.CalculateCircumference());
    }
}
