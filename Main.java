import java.util.Scanner;
public class Main
{
    public Static void main(String[] args)
    {
        Scanner abc = new Scanner(System.in);
        System.out.print("first no");
        int num1=abc.nextInt();

        System.out.print("2nd no");
        int num2=abc.nextInt();

        System.out.print("3rd no");
        int num3=abc.nextInt();


        min=num1
        if(num2<min)
        {
        min=num2;
        }

        if(num3<min){
            min=num3
        }
        System.out.println("The minimun number is "+min);
    }
}