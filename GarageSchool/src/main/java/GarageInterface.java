import java.util.ArrayList;

public interface GarageInterface {

    void park(Vehicle vehicle, int parkingSlot);

    void unpark(Vehicle vehicle);

    Vehicle getVehicleByRegistrationNumber(String registrationNumber);

    //to print out their properties
    String getVehicles();

    ArrayList<String> getTypesParked();

    void setMaxCapacity(int maxCapacity);

    int findParkingLot(int i);
}
