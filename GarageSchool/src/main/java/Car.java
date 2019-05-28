public class Car extends Vehicle{

    private int cylinderVolume;

    public Car(){
        super();
        cylinderVolume = 1600;
    }

    public Car(String registrationNumber){
        super(registrationNumber);
        cylinderVolume = 4;
    }

    public Car(String registrationNumber, Color color, int numberOfWheels, int cylinderVolume) {
        super(registrationNumber, color, numberOfWheels);
        this.cylinderVolume = cylinderVolume;
    }

    public boolean park(Garage garage){
        /*
        go through the garage, when we find an empty slot, we park the vehicle there.
         */
        int emptySlot = garage.findParkingLot(Vehicle.CAR);
        if(emptySlot != -1){
            garage.park(this, emptySlot);
            return true;
        }
        return false;
    }

    public String toString(){
        return super.toString()+'\''+", cc: "+cylinderVolume;
    }

}