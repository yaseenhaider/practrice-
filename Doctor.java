import java.time.LocalDate;

                                     // Base class
class Appointment {
    int appointmentId;
    String patientName;
    LocalDate appointmentDate;

                                        // Constructor
    Appointment(int id, String name, LocalDate date) {
       this. appointmentId = id;
       this. patientName = name;
       this. appointmentDate = date;
    }

                                     // Method to display appointment details
    void displayAppointmentDetails() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Appointment Date: " + appointmentDate);
    }
}

                                     // Doctor appointment class
class DoctorAppointment extends Appointment {
    String specialistType;

    DoctorAppointment(int id, String name, LocalDate date, String specialist) {
        super(id, name, date); // Call parent constructor
        this.specialistType = specialist;
    }

                                          // Overriding method
    void displayAppointmentDetails() {
        super.displayAppointmentDetails();
        System.out.println("Specialist Type: " + specialistType);
    }
}

// Lab test appointment class
class LabTestAppointment extends Appointment {
    String testType;

    LabTestAppointment(int id, String name, LocalDate date, String test) {
        super(id, name, date); // Call parent constructor
        this.testType = test;
    }

                                       // Overriding method
    void displayAppointmentDetails() {
        super.displayAppointmentDetails();
        System.out.println("Test Type: " + testType);
    }
}

// Main
public class Doctor{
                                     // Method to compare appointment dates
    static void compareAppointments(Appointment a1, Appointment a2) {
        if (a1.appointmentDate.equals(a2.appointmentDate)) {
            System.out.println("Appointments are on the same day.");
        } else {
            System.out.println("Appointments are on different days.");
        }
    }

    public static void main(String[] args) {
                                          // Create doctor appointment
        DoctorAppointment doctor = new DoctorAppointment(1, "John Doe", LocalDate.of(2025, 4, 20), "Dermatologist");

                                             // Create lab test appointment
        LabTestAppointment lab = new LabTestAppointment(2, "Jane Smith", LocalDate.of(2025, 4, 20), "Blood Test");

                                           // Display details
        System.out.println("Doctor Appointment:");
        doctor.displayAppointmentDetails();

        System.out.println("\nLab Test Appointment:");
        lab.displayAppointmentDetails();

                                                // Compare appointments
        System.out.println("\nComparing appointments:");
        compareAppointments(doctor, lab);
    }
}
