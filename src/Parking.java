import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {

    private List<ParkingSpot> spots = new ArrayList<>();

    public Parking(int totalSpots) {

        int smallCount = (int) (totalSpots * 0.4);
        int mediumCount = (int) (totalSpots * 0.4);
        int largeCount = totalSpots - smallCount - mediumCount;

        int spotNumber = 1;

        for (int i = 0; i < smallCount; i++) {
            spots.add(new ParkingSpot(spotNumber++, SpotSize.SMALL));
        }

        for (int i = 0; i < mediumCount; i++) {
            spots.add(new ParkingSpot(spotNumber++, SpotSize.MEDIUM));
        }

        for (int i = 0; i < largeCount; i++) {
            spots.add(new ParkingSpot(spotNumber++, SpotSize.LARGE));
        }

    }


    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                if (vehicle.getVehicleType().canParkOn(spot.getSize())) {
                    spot.occupy(vehicle);
                    System.out.println("Vehicle " + vehicle.getLicensePlate() + " stay at no. - " + spot.getSpotNumber());
                    return true;
                }
            }
        }
        System.out.println("No free places for this type: " + vehicle.getVehicleType());
        return false;
    }

    public double exitParking(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(licensePlate)) {
                Vehicle vehicle = spot.free();

                double cost = vehicle.calculateCost(LocalDateTime.now());
                System.out.println("Your vehicle is here: " + vehicle + " cost: " + cost);
                return cost;
            }
        }
        System.out.println("Can't find vehicle: " + licensePlate);
        return 0;
    }

    public void showOccupiedSpots() {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied()) {
                System.out.println(spot.getVehicle());
            }
        }
    }

    public void showFreeSpots() {
        System.out.println("=== FREE SPOTS ===");
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                System.out.printf("Place #%d (%s)%n",
                        spot.getSpotNumber(),
                        spot.getSize());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Every occupied");
        }
    }

    public boolean isVehicleParked(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle().getLicensePlate().equals(licensePlate)) {
                return true;
            }
        }
        return false;
    }

}
