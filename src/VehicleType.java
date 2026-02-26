public enum VehicleType {
    MOTORCYCLE(SpotSize.SMALL, 2.0),
    CAR(SpotSize.MEDIUM, 5.0),
    TRUCK(SpotSize.LARGE, 10.0);

    private final SpotSize minSpotSize;
    private final double hourlyRate;

    VehicleType(SpotSize minSpotSize, double hourlyRate) {
        this.minSpotSize = minSpotSize;
        this.hourlyRate = hourlyRate;
    }

    public SpotSize getMinSpotSize() {
        return minSpotSize;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public boolean canParkOn(SpotSize spotSize) {
        return spotSize.ordinal() >= minSpotSize.ordinal();
    }
}
