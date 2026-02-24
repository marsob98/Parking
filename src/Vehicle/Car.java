package Vehicle;

import java.time.LocalDate;

public class Car extends AbstractVehicle implements Vehicle {

    public Car(String id, VehicleType type, LocalDate time) {
        super(id, type, time);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.MEDIUM;
    }
}
