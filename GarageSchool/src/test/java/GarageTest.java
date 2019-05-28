import org.junit.Test;

import static org.junit.Assert.*;

public class GarageTest {

    @Test
    public void park() {
        Garage testGarage = new Garage();
        Vehicle testVehicle1 = new Car("QWE001");
        Vehicle testVehicle2 = new Car("QWE001");
        Vehicle testVehicle3 = new Car("QWE003");
        Vehicle testVehicle4 = new Car("QWE004");
        Vehicle testVehicle5 = new Car("QWE005");

        Vehicle testVehicle6 = new Bus("RTY412", 30);

        Vehicle testMotorbike1 = new Motorcycle("DSL007", "gasoline");



        testGarage.park(testVehicle6, testGarage.findParkingLot(Vehicle.BUS));
        testGarage.park(testVehicle1, testGarage.findParkingLot(Vehicle.CAR));
        testGarage.park(testVehicle2, testGarage.findParkingLot(Vehicle.CAR));
        testGarage.park(testVehicle3, testGarage.findParkingLot(Vehicle.CAR));
        testGarage.park(testVehicle4, testGarage.findParkingLot(Vehicle.CAR));
        testGarage.park(testVehicle5, testGarage.findParkingLot(Vehicle.CAR));
        testGarage.park(testMotorbike1, testGarage.findParkingLot(Vehicle.MOTORCYCLE));
/*
        for(int i=1; i<=96; i++){
            testGarage.park(new EmptyVehicle(), 1);
        }
*/
        testGarage.unpark("QWE003");
        testGarage.unpark("QWE004");

        /*
        assertSame( testVehicle1, testGarage.getVehicleByRegistrationNumber("QWE001"));
        assertSame(testMotorbike1, testGarage.getVehicleByRegistrationNumber("DSL007"));
        assertSame(testVehicle6, testGarage.getVehicleByRegistrationNumber("RTY412"));
        assertSame(testVehicle3, testGarage.getVehicleByRegistrationNumber("QWE003"));
        */

        System.out.println(testGarage);
    }

    @Test
    public void unpark() {
        Garage testGarage = new Garage();
        Vehicle testVehicle1 = new Car("QWE542");
        Vehicle testVehicle2 = new Bus("RTY412", 30);

        testGarage.park(testVehicle1, testGarage.findParkingLot(Vehicle.CAR));
        testGarage.park(testVehicle2, testGarage.findParkingLot(Vehicle.BUS));

        System.out.println(testGarage);

        testGarage.unpark(testVehicle2);

        assertSame(testVehicle1, testGarage.getVehicleByRegistrationNumber("QWE542"));
        assertNotSame(testVehicle2, testGarage.getVehicleByRegistrationNumber("RTY412"));
    }

    @Test
    public void getVehicleByRegistrationNumber() {
        Garage testGarage = new Garage();
        Vehicle testVehicle1 = new Car();
        Vehicle testVehicle2 = new Motorcycle("ASD123", "gasoline");

        testGarage.park(testVehicle1, testGarage.findParkingLot(Vehicle.CAR));
        testGarage.park(testVehicle2, testGarage.findParkingLot(Vehicle.BUS));

        assertSame(testVehicle2, testGarage.getVehicleByRegistrationNumber("ASD123") );
    }

    @Test
    public void getVehicles() {
    }

    @Test
    public void getTypesParked() {
    }

    @Test
    public void setMaxCapacity() {
    }

    @Test
    public void save() {
    }

    @Test
    public void load() {
    }
}