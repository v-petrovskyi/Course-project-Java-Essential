package entities;

import entities.Transport;

public class Tram extends Transport {
    private int qtyOfTramCars;

    public Tram(int id, String brand, int passengers, DriverQualificationEnum driverQualificationEnum, int qtyOfTramCars) {
        super(id, brand, passengers, driverQualificationEnum);
        this.qtyOfTramCars = qtyOfTramCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tram tram = (Tram) o;

        return qtyOfTramCars == tram.qtyOfTramCars;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + qtyOfTramCars;
        return result;
    }

    public int getQtyOfTramCars() {
        return qtyOfTramCars;
    }

    public void setQtyOfTramCars(int qtyOfTramCars) {
        this.qtyOfTramCars = qtyOfTramCars;
    }

}
