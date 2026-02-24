package Vehicle;

import java.time.LocalDate;

public class Truck extends AbstractVehicle implements Vehicle {
    public Truck(String id, VehicleType type, LocalDate time) {
        super(id, type, time);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.HEAVY;
    }
}
