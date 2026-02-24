package Vehicle;

import java.time.LocalDate;

public class Motorcycle extends AbstractVehicle implements Vehicle {

    public Motorcycle(String id, VehicleType type, LocalDate time) {
        super(id, type, time);
    }

    @Override
    public String  getId() {
        return id;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SMALL;
    }
}
