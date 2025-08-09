import java.util.Scanner;
public class ExceptionHandlingExample
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int a, b, choice;
        do { 
            System.out.print("Enter 1st value"); a=input.nextInt();
            System.out.print("Enter 2nd value"); b=input.nextInt();
            System.out.print("1:Add\n2:Subtract\n3:Multiply\n4:Divide\n5:Quit\nEnter your choice:");
            choice=input.nextInt();
            try{
                switch(choice)
                {
                    case 1: System.out.println(a+"+"+b+"="+(a+b));
                    break;
                    case 2: System.out.println(a+"-"+b+"="+(a-b));
                    break;
                    case 3: System.out.println(
                        break;
                        case 5: break;
                        default: System.out.println("You have entered an ivalid choice");
                }
            }
            catch(ArithmaticException e)
            {
                System.out.println("It is divided by ZERO exception");
                System.out.println("Try again");
            }
        }while(choice!=5);
    }
}