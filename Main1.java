class Vehicle {
    protected String plateNumber;
    protected String ownerName;
    protected String vehicleType;

    // Constructor
    public Vehicle(String plateNumber, String ownerName, String vehicleType) {
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Method to be overridden
    public void displayVehicleInfo() {
        System.out.println("Plate Number: " + plateNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}
 class ElectricVehicle extends Vehicle {
    private int batteryLevel;

    // Constructor chaining using super()
    public ElectricVehicle(String plateNumber, String ownerName, int batteryLevel) {
        super(plateNumber, ownerName, "Electric");
        this.batteryLevel = batteryLevel;
    }

    // Overriding method
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Battery Level: " + batteryLevel + "%");
    }
}
 class DisabledAccessVehicle extends Vehicle {
    private String disabilityPermitNumber;

    // Constructor chaining using super()
    public DisabledAccessVehicle(String plateNumber, String ownerName, String disabilityPermitNumber) {
        super(plateNumber, ownerName, "Disabled Access");
        this.disabilityPermitNumber = disabilityPermitNumber;
    }

    // Overriding method
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Disability Permit Number: " + disabilityPermitNumber);
    }
}
public class Main1 {
    public static void main(String[] args) {
        // Create sample Electric Vehicle
        ElectricVehicle ev = new ElectricVehicle("EV123", "babar", 82);

        // Create sample Disabled Access Vehicle
        DisabledAccessVehicle dav = new DisabledAccessVehicle("DA456", "Neha Verma", "DP-1001");

        // Display information using overridden methods
        System.out.println("=== Electric Vehicle Details ===");
        ev.displayVehicleInfo();

        System.out.println("\n=== Disabled Access Vehicle Details ===");
        dav.displayVehicleInfo();
    }
}
