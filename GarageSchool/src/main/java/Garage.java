import java.io.*;
import java.util.*;

public class Garage implements GarageInterface {

    //You have to set your own absolute path
    private static String filePath = "C:\\Users\\zgrkbr\\git\\Garage\\garage.kib";

    private int maxCapacity = 30;

    private Map<Integer, Vehicle> vehicles = new HashMap<>(maxCapacity);

    public Garage() {

    }

    public void park(Vehicle vehicle, int parkingSlot) {
        vehicle.setParkinglotNumber(parkingSlot);
        vehicles.put(parkingSlot, vehicle);
    }

    public void unpark(Vehicle vehicle) {
        vehicles.remove(vehicle.getParkinglotNumber());
        vehicle.setParkinglotNumber(0);
    }

    public void unpark(String registrationNumber){
        Collection<Vehicle> temp = vehicles.values();
        Iterator iter = temp.iterator();

        while(iter.hasNext()){
            Vehicle v = (Vehicle)iter.next();
            if(v.getRegistrationNumber().equalsIgnoreCase(registrationNumber)){
                int lotNumber = v.getParkinglotNumber();
                vehicles.remove(lotNumber);
                break;
            }
        }
    }

    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
        Collection<Vehicle> temp = vehicles.values();
        for (Vehicle vehicle : temp) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                return vehicle;
            }
        }
        return new EmptyVehicle();
    }

    //to be implemented
    public String getVehicles() {
        return null;
    }

    public ArrayList<String> getTypesParked() {
        return null;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) throw new IllegalArgumentException("The capacity may not be less than 1");
        this.maxCapacity = maxCapacity;
    }

    @Override
    public int findParkingLot(int offset) {
        for (int i = offset; i <= offset+10; i++) {
            if (!vehicles.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    public void save() {
        File file = new File(filePath);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(this);
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write.");
        }
    }//save

    public static Garage load() {
        Garage temp = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            temp = (Garage) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Load error");
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible error");
        }
        return temp;
    }//load

    public String toString(){
        String output = "";
        Collection<Vehicle> temp = vehicles.values();
        for(Vehicle v : temp){
            output += v+"\n";
        }
        output += "Max capacity: "+maxCapacity;
        return output;
    }

}
