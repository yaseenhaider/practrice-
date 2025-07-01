import java.util.Scanner;

public class Task1
 {
    public static void main(String[] args) {
        Scanner yh = new Scanner(System.in);

        // Prompt user for the first point's latitude and longitude
        System.out.print("Enter the latitude of the first point (in degrees): ");
        double latitude1 = yh.nextDouble();
        System.out.print("Enter the longitude of the first point (in degrees): ");
        double longitude1 = yh.nextDouble();

        // Prompt user for the second point's latitude and longitude
        System.out.print("Enter the latitude of the second point (in degrees): ");
        double latitude2 = yh.nextDouble();
        System.out.print("Enter the longitude of the second point (in degrees): ");
        double longitude2 = yh.nextDouble();

        // Convert degrees to radians
        double lat1Rad = Math.toRadians(latitude1);
        double lon1Rad = Math.toRadians(longitude1);
        double lat2Rad = Math.toRadians(latitude2);
        double lon2Rad = Math.toRadians(longitude2);

        // Haversine formula
        final int EARTH_RADIUS = 6371; // Average radius of Earth in kilometers

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS * c; // Distance in kilometers

        // Display the result
        System.out.printf("The great circle distance between the two points is: %.2f km%n", distance);

        // Close the scanner
        scanner.close();
    }
}