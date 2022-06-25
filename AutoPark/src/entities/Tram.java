package entities;

import entities.Transport;

public class Tram extends Transport {
    private int qtyOfTramCars;

    public Tram(int id, String brand, int passengers, DriverQualificationEnum driverQualificationEnum, int qtyOfTramCars) {
        super(id, brand, passengers, driverQualificationEnum);
        this.qtyOfTramCars = qtyOfTramCars;
    }

}
