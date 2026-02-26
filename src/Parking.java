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
            spots.add(new ParkingSpot(spotNumber, SpotSize.SMALL));
        }

        for (int i = 0; i < mediumCount; i++) {
            spots.add(new ParkingSpot(spotNumber, SpotSize.MEDIUM));
        }

        for (int i = 0; i < largeCount; i++) {
            spots.add(new ParkingSpot(spotNumber, SpotSize.LARGE));
        }

    }




    public void parkVehicle(Vehicle vehicle) {

    }

    public void exitParking(Vehicle vehicle) {

    }


}
