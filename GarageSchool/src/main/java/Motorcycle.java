public class Motorcycle extends Vehicle {

    String fuelType;

    public Motorcycle(){
        super();
        fuelType = "gasoline";
    }

    public Motorcycle(String fuelType) {
        super();
        this.fuelType = fuelType;
    }

    public Motorcycle(String registrationNumber, String fuelType) {
        super(registrationNumber);
        this.fuelType = fuelType;
    }

    public Motorcycle(String registrationNumber, Color color, int numberOfWheels, String fuelType) {
        super(registrationNumber, color, numberOfWheels);
        this.fuelType = fuelType;
    }

    @Override
    public boolean park(Garage garage) {
        int emptySlot = garage.findParkingLot(Vehicle.MOTORCYCLE);
        if(emptySlot != -1){
            garage.park(this, emptySlot);
            return true;
        }
        return false;
    }
}