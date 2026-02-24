package Vehicle;

public class Motorcycle extends AbstractVehicle implements Vehicle {

    @Override
    public void getId() {

    }

    @Override
    public VehicleType getType() {
        return VehicleType.SMALL;
    }
}
