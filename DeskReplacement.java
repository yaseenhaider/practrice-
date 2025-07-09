import java.util.Scanner;
public class DeskReplacement 
{
    public static void main(String[] args)
    {
        // Read the number of students in each class
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students in class A: ");
        int a = scanner.nextInt();
        System.out.print("Enter the number of students in class B: ");
        int b = scanner.nextInt();
        System.out.print("Enter the number of students in class C: ");
        int c = scanner.nextInt();
        scanner.close();

        // Calculate the total number of students
        int totalStudents = a + b + c;

        // Calculate the smallest possible number of desks
        int desks = (totalStudents + 1) / 2;

        // Print the result
        System.out.println(desks);
    }
}