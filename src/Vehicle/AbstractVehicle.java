package Vehicle;

import java.time.LocalDate;

public abstract class AbstractVehicle {
    String id;
    VehicleType type;
    LocalDate time;

    public AbstractVehicle(String id, VehicleType type, LocalDate time) {
        this.id = id;
        this.type = type;
        this.time = time;
    }

    public LocalDate getTime() {
        return time;
    }
}
