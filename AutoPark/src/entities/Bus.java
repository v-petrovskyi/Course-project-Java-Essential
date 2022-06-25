package entities;

import entities.Transport;

public class Bus extends Transport {
    private String type;
    private int qtyOfDoors;

    public Bus(int id, String brand, int passengers, DriverQualificationEnum driverQualificationEnum) {
        super(id, brand, passengers, driverQualificationEnum);
    }
}
