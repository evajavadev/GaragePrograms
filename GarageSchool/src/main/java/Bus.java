public class Bus extends Vehicle{

    int numberOfSeats;

    public Bus(){
        super();
        numberOfSeats = 40;
    }


    public Bus(int numberOfSeats) {
        super();
        this.numberOfSeats = numberOfSeats;
    }

    //numberOfSeats can be set to 0 or less.
    public Bus(String registrationNumber, int numberOfSeats) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
    }

    public Bus(String registrationNumber, Color color, int numberOfWheels, int numberOfSeats) {
        super(registrationNumber, color, numberOfWheels);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    //returns -1 instead of throwing exception
    public boolean park(Garage garage) {
        int emptySlot = garage.findParkingLot(Vehicle.BUS);
        if(emptySlot != -1){
            garage.park(this, emptySlot);
            return true;
        }
        return false;
    }


}
