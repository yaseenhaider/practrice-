 class CourseResult {
    public String studentname;
    public String coursename;
    public String grade;
    public void display()
    {
        System.out.println("Student Name is:"+studentname+"Course Name is:"+ coursename+ "Grade is:"+grade);
    }
 }
 public class CourseResultRun {
    public static void main(String[] args)
    {
        CourseResult c1 = new CourseResult();
        c1.studentname="Ali";
        c1.coursename="OOP";
        c1.grade="A";
        c1.display();
        CourseResult c2 =new CourseResult();
        c2.studentname="HAIDER";
        c2.coursename="ICP";
        c2.grade="A+";
        c2.display();

    }
 }