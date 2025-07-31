
class Bank{
    int x;
    String y;


    Bank(){
        x=0;
        y="defualt";

    }

    Bank(int val){
        x=val;
    }

    Bank(int val,String str){
        x=val;
        y=str;
    }

}
public class Load{
    public static void main(String[] args) {
        Bank b1 = new Bank();
        Bank b2 = new Bank(10);
        Bank b3 = new Bank(20,"haider");
    }
}