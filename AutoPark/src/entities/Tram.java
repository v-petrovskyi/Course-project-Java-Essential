package entities;

import entities.Transport;

public class Tram extends Transport {
    private int qtyOfTramCars;

    public Tram(int id, String brand, int passengers, Driver driver, Route route, DriverQualificationEnum driverQualificationEnum) {
        super(id, brand, passengers, driver, route, driverQualificationEnum);
    }
}
