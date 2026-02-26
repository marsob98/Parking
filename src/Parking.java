import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {

    List<ParkingSpot> spots = new ArrayList<>();

    public Parking(int totalSpots) {

        int smallCount = (int)(totalSpots * 0.4);
        int mediumCount = (int)(totalSpots * 0.4);
        int largeCount =  totalSpots - smallCount - mediumCount;

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
                    System.out.println("Zaparkowano " + vehicle.getLicensePlate() + " na miejscu - " + spot.getSpotNumber());
                    return true;
                }
            }
        }
        System.out.println("Brak wolnych miejsc dla " + vehicle.getVehicleType());
        return  false;
    }

    public double exitParking(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(licensePlate)) {
                Vehicle vehicle = spot.free();

                double cost = vehicle.calculateCost(LocalDateTime.now());
                System.out.println("Zakończono parkowanie pojazdu: " + vehicle + " do zapłaty: " + cost);
                return  cost;
            }
        }
        System.out.println("Nie znaleziono pojazdu: " + licensePlate);
        return 0;
    }

    public void showOccupiedSpots() {
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).getVehicle() == null) {
                continue;
            }
            System.out.println(spots.get(i).getVehicle());
        }
    }


}
