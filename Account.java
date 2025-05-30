class Account1 {
    private int Balance;

    public Account1() {
        Balance = 1000000;
    }

    public Account1(int x) {
        Balance=x;

    }
    public void SetBalance(int x){
        Balance = x;
    }
    public  int GetBalance(){
        return Balance;
    }
    public void deposit(int x){
        Balance +=x;
    }
    public void withdraw(int x){
        Balance -=x;
    }
    public void display(){
        System.out.println("this balance is "+Balance);
    }
}
public class Account{
    public static void main(String[] args) {
        Account1 mark1 = new Account1();
        mark1.display();
        mark1.deposit(90000000);
        mark1.display();
        mark1.withdraw(9090);
        mark1.display();

    }
}