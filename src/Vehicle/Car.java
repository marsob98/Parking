package Vehicle;

public class Car extends AbstractVehicle implements Vehicle {

    @Override
    public void getId() {

    }

    @Override
    public VehicleType getType() {
        return VehicleType.MEDIUM;
    }
}
