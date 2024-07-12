






import java.util.Date;
import java.util.Scanner;

class Customer {
    public int c_id;
    public String c_name;
    public Long c_mobile;
    public String c_address;
    public String c_email;
    public String driver_licence_number;
}

class Vehicle {
    public int v_id;
    public String v_model;
    public double daily_price;
    public String pollution_certificate;
    public String insurance;
    public String licence_plate_number;
    public String rc;
}

class Booking {
    public int b_id;
    public Date b_start_date;
    public Date b_end_date;
    public int days;
    public double b_total_cost;
    public String pickup_location;
    public String dropoff_location;
    public String booking_status;
    public int c_id; // Foreign key to Customer
    public int v_id; // Foreign key to Vehicle
}

class Payment {
    public int p_id;
    public double amount;
    public String p_method;
    public int b_id; // Foreign key to Booking

    // Default constructor (not used explicitly in Main)
    public Payment() {
        // Default constructor
    }
}

 class main61 {
    public static void main(String[] args) {

        System.out.println("\n           WELCOME to Online car rental system \nplease Enter your Details:");

        Scanner sc = new Scanner(System.in);

        // Create a customer
        Customer customer = new Customer();

        System.out.print("Enter your id: ");
        customer.c_id = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        System.out.print("Your name: ");
        customer.c_name = sc.nextLine();

        System.out.print("Address: ");
        customer.c_address = sc.nextLine();

        System.out.print("Mobile number: ");
        customer.c_mobile = sc.nextLong();
        sc.nextLine(); // consume the leftover newline

        System.out.print("Email id: ");
        customer.c_email = sc.nextLine();

        System.out.print("Licence Details: ");
        customer.driver_licence_number = sc.nextLine();

        // Initialize vehicle array with real-world models
        Vehicle[] vehicles = new Vehicle[10];
        String[] models = {
            "Maruti Suzuki Swift",
            "Honda City",
            "Toyota Innova",
            "Hyundai Creta",
            "Ford EcoSport",
            "Renault Duster",
            "Tata Nexon",
            "Kia Seltos",
            "MG Hector",
            "Skoda Octavia"
        };
        double[] prices = {2000, 2300, 2500, 2200, 2100, 2400, 2000, 2700, 2600, 2800};

        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Vehicle();
            vehicles[i].v_id = i + 1;
            vehicles[i].v_model = models[i];
            vehicles[i].daily_price = prices[i];
            vehicles[i].pollution_certificate = "Valid";
            vehicles[i].insurance = "Comprehensive";
            vehicles[i].licence_plate_number = "RJ16GH" + (234 + i);
            vehicles[i].rc = "RC" + (123 + i);
        }

        // Loop to ensure vehicle selection
        Vehicle selectedVehicle = null;
        for (;;) {
            // Display vehicle options
            System.out.println("\nSelect your vehicle:");
            for (int i = 0; i < vehicles.length; i++) {
                System.out.println((i + 1) + ". " + vehicles[i].v_model + 
                                   " (Daily Price: " + vehicles[i].daily_price + 
                                   ", Plate Number: " + vehicles[i].licence_plate_number + ")");
            }

            // Prompt user for vehicle selection
            System.out.print("Select your car (1-10): ");
            int vehicleChoice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline

            // Validate the selection
            if (vehicleChoice >= 1 && vehicleChoice <= 10) {
                selectedVehicle = vehicles[vehicleChoice - 1]; // Get the selected vehicle
                System.out.println("You selected: " + selectedVehicle.v_model);
                System.out.println("Vehicle status: Available");
                break; // Exit the loop since a valid vehicle is selected
            } else {
                System.out.println("Invalid choice, please try again."); // Prompt to try again if the choice is invalid
            }
        }

        // Enter booking days
        System.out.print("Enter number of days for booking: ");
        int days = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        // Calculate amount
        double amount = days * selectedVehicle.daily_price;
        System.out.println("Amount is: " + amount);

        // Create a booking
        Booking booking = new Booking();
        booking.b_id = 1;
        booking.b_start_date = new Date(); // Assume current date for simplicity
        booking.b_end_date = new Date(booking.b_start_date.getTime() + (1000 * 60 * 60 * 24 * days)); // days later
        booking.days = days;
        booking.b_total_cost = amount;
        booking.pickup_location = "Delhi";
        booking.dropoff_location = "Mumbai";
        booking.booking_status = "Confirmed";
        booking.c_id = customer.c_id;
        booking.v_id = selectedVehicle.v_id;

        // Create a payment
        Payment payment = new Payment();
        payment.p_id = 1;
        payment.amount = amount;
        payment.p_method = "Credit Card";
        payment.b_id = booking.b_id;

        // Output the details
        System.out.println("\nBooking Details:");
        System.out.println("Customer: " + customer.c_name + "\nMobile: " + customer.c_mobile);
        System.out.println("Vehicle: " + selectedVehicle.v_model + ", Daily Price: " + selectedVehicle.daily_price);
        System.out.println("Booking ID: " + booking.b_id);
        System.out.println("Booking Date: " + booking.b_start_date);
        System.out.println("Return Date: " + booking.b_end_date);
        System.out.println("Total Cost: " + booking.b_total_cost);

        // Output the payment details
        System.out.println("\nPayment Details:");
        System.out.println("Payment ID: " + payment.p_id);
        System.out.println("Amount: " + payment.amount);
        System.out.println("Payment Method: " + payment.p_method);

        // Generate invoice
        System.out.println("\nInvoice:");
        System.out.println("Customer Name: " + customer.c_name);
        System.out.println("Mobile: " + customer.c_mobile);
        System.out.println("Email: " + customer.c_email);
        System.out.println("Address: " + customer.c_address);
        System.out.println("Selected Vehicle: " + selectedVehicle.v_model);
        System.out.println("Plate Number: " + selectedVehicle.licence_plate_number);
        System.out.println("Amount: " + amount);
        System.out.println("\nThank you! Enjoy your journey.");
    }
}

