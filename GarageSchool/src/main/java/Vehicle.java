import java.util.ArrayList;

public abstract class Vehicle {

    protected String registrationNumber;

    protected int numberOfWheels;

    protected int parkinglotNumber;

    protected Color color;

    protected static ArrayList<String> takenRegistrationNumbers = new ArrayList<>();

    protected static int CAR = 1;
    protected static int MOTORCYCLE = 11;
    protected static int BUS = 21;

    public Vehicle(){
        registrationNumber = "AAA111";
        color = Color.PURPLE;
        numberOfWheels = 4;
    }

    public Vehicle(String registrationNumber){
        if( !setRegistrationNumber(registrationNumber) )
            throw new IllegalArgumentException("The registration number "+registrationNumber+" is already taken.");
        color = Color.RED;
        numberOfWheels = 4;
    }

    public Vehicle(String registrationNumber, Color color, int numberOfWheels){
        this.registrationNumber = registrationNumber;
        color = Color.RED;
        this.numberOfWheels = numberOfWheels;
    }

    public abstract boolean park(Garage garage);

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean setRegistrationNumber(String registrationNumber){
        for(String regnum : takenRegistrationNumbers){
            if(regnum.equalsIgnoreCase(registrationNumber)) {
                return false;
            }
        }
        takenRegistrationNumbers.add(registrationNumber);
        this.registrationNumber = registrationNumber;
        return true;
    }

    public int getParkinglotNumber() {
        return parkinglotNumber;
    }

    public void setParkinglotNumber(int parkinglotNumber) {
        this.parkinglotNumber = parkinglotNumber;
    }

    @Override
    public String toString() {
        return  "registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", numberOfWheels=" + numberOfWheels +
                ", parkinglotNumber=" + parkinglotNumber;
    }
}
