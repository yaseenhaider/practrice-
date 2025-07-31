
class Animal{
    public void sound(){
        System.out.println("animal make a sound ");
    }
}
class Dog extends Animal{
    public void sound(){
        System.out.println("dog bark");
    }
}
class  cat extends Animal{
    public void sound(){
        System.out.println("cat meow");
    }
}
public class Main{
    public static void main(String[] args) {
        Animal a1=new cat();
        a1.sound();
    }
}