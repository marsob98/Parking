public class ParkingSpot {
    private int spotNumber;
    private SpotSize size;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, SpotSize size) {
        this.spotNumber = spotNumber;
        this.size = size;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public SpotSize getSize() {
        return size;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
