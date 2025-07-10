class CourseResult {
    public String studentname;
    public String coursename;
    public String grade;

    // Method to display student details
    public void display() {
        System.out.println("Student Name: " + studentname + 
                           ", Course Name: " + coursename + 
                           ", Grade: " + grade);
    }
}

public class CourseResultRun {
    public static void main(String[] args) {
        // Creating first object
        CourseResult c1 = new CourseResult();
        c1.studentname = "Ali";
        c1.coursename = "OOP";
        c1.grade = "A";
        c1.display();

        // Creating second object
        CourseResult c2 = new CourseResult();
        c2.studentname = "Haider";
        c2.coursename = "ICP";
        c2.grade = "A+";
        c2.display();
    }
}
