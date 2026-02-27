import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(100);
        Vehicle vehicle = new Vehicle("12345", VehicleType.CAR, LocalDateTime.now());
        Vehicle vehicle2 = new Vehicle("54321", VehicleType.TRUCK, LocalDateTime.now());
        Vehicle vehicle3 = new Vehicle("qwert", VehicleType.MOTORCYCLE, LocalDateTime.now());
        parking.parkVehicle(vehicle);
        parking.parkVehicle(vehicle2);
        parking.parkVehicle(vehicle3);

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        boolean flag = true;
        while (flag) {
            System.out.println("=== MENU ===");
            System.out.println("1. Park vehicle");
            System.out.println("2. Exit vehicle");
            System.out.println("3. Show Occupied spots");
            System.out.println("4. Show free spots");

            System.out.println("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Write license plate number: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println("Type of vehicle?");
                    System.out.println("1 - Motorcycle");
                    System.out.println("2 - Car");
                    System.out.println("3 - Truck");
                    int c = scanner.nextInt();
                    scanner.nextLine();

                    VehicleType type = null;
                    switch (c) {
                        case 1 -> type = VehicleType.MOTORCYCLE;
                        case 2 -> type = VehicleType.CAR;
                        case 3 -> type = VehicleType.TRUCK;
                        default -> {
                            System.out.println("Wrong type");
                            continue;
                        }
                    }

                    LocalDateTime now = LocalDateTime.now();
                    Vehicle vehicle1 = new Vehicle(licensePlate, type, now);
                    parking.parkVehicle(vehicle1);
                    System.out.println("You've parked your car at " + now.format(formatter));
                    break;

                case 2:
                    System.out.println("Which car do you want to exit (choose license plate number): ");
                    parking.showOccupiedSpots();
                    String plate = scanner.nextLine();



                    break;
                case 3:
                    break;
                case 4:
                    break;


            }
        }
    }
}