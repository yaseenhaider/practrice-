class Time {
    int hours, minutes, seconds;

    Time(int h, int m, int s) {
        hours = h;
        minutes = m;
        seconds = s;
    }


    void showTime() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }


    void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours = (hours + 1) % 24; // Keep in 24-hour format
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Time t = new Time(14, 59, 59); // Create Time object
        t.showTime();  // Show current time

        t.tick();  // Add one second
        t.showTime();  // Show updated time
    }
}
