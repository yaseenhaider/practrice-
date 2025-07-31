class Small{
    private int someData;

    public void setData(int d){
        someData=d;
    }
    public void showData(){
        System.out.println("data is :"+someData);
    }
}
public class Data {
    public static void main(String[] args) {
        Small s1=new Small();
        Small s2= new Small();

        s1.setData(244);
        s2.setData(355);


        s1.showData();
        s2.showData();
    }
}