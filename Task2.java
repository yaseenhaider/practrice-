import java.util.Scanner;


class Publication {
    String title;
    double price;

    void set(String title, double price) {
        this.title = title;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Price: $" + price);
    }
}


class Book extends Publication {
    int pageCount;

    void set(String title, double price, int pageCount) {
        super.set(title, price);
        this.pageCount = pageCount;
    }

    void display() {
        super.display();
        System.out.println("Pages: " + pageCount);
    }
}


class Tape extends Publication {
    int playTime;  // in minutes

    void set(String title, double price, int playTime) {
        super.set(title, price);
        this.playTime = playTime;
    }

    void display() {
        super.display();
        System.out.println("Play Time: " + playTime + " minutes");
    }
}


public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Book details
        System.out.println("Enter Book Details:");
        System.out.print("Title: ");
        String bookTitle = input.nextLine();
        System.out.print("Price: ");
        double bookPrice = input.nextDouble();
        System.out.print("Page Count: ");
        int bookPages = input.nextInt();
        input.nextLine(); // Consume newline

        Book myBook = new Book();
        myBook.set(bookTitle, bookPrice, bookPages);

        // Tape details
        System.out.println("\nEnter Tape Details:");
        System.out.print("Title: ");
        String tapeTitle = input.nextLine();
        System.out.print("Price: ");
        double tapePrice = input.nextDouble();
        System.out.print("Play Time (in minutes): ");
        int tapeTime = input.nextInt();

        Tape myTape = new Tape();
        myTape.set(tapeTitle, tapePrice, tapeTime);

        // Display entered data
        System.out.println("\nBook Details:");
        myBook.display();

        System.out.println("\nTape Details:");
        myTape.display();

        input.close();
    }
}
