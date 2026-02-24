package Vehicle;

public class Truck extends AbstractVehicle implements Vehicle {
    @Override
    public void getId() {

    }

    @Override
    public VehicleType getType() {
        return VehicleType.HEAVY;
    }
}
