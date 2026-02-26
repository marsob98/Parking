import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Vehicle fura = new Vehicle("DX81699", VehicleType.CAR, LocalDateTime.now());
        Vehicle motor = new Vehicle("DX12345", VehicleType.MOTORCYCLE, LocalDateTime.now());
        Vehicle tir = new Vehicle("DW12345", VehicleType.TRUCK, LocalDateTime.now());

        Parking parking = new Parking(100);

        parking.parkVehicle(motor);
        parking.parkVehicle(fura);
        parking.parkVehicle(tir);

        parking.showOccupiedSpots();

        parking.exitParking("DX12345");
        parking.exitParking("DX81669");
        parking.exitParking("DW12345");


    }
}