import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Vehicle {
    private final String licensePlate;
    private final VehicleType vehicleType;
    private final LocalDateTime entryTime;

    public Vehicle(String licensePlate, VehicleType vehicleType, LocalDateTime entryTime) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public double calculateCost(LocalDateTime exitTime) {
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        long hours = minutes / 60;
        if (minutes % 60 > 0) {
            hours++;
        }
        return hours * vehicleType.getHourlyRate();

    }

}
