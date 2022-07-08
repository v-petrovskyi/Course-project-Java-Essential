package entities;

import entities.Transport;

public class Bus extends Transport {
    private String type;
    private int qtyOfDoors;

    public Bus(int id, String brand, int passengers, DriverQualificationEnum driverQualificationEnum, String type, int qtyOfDoors) {
        super(id, brand, passengers, driverQualificationEnum);
        this.type = type;
        this.qtyOfDoors = qtyOfDoors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bus bus = (Bus) o;

        if (qtyOfDoors != bus.qtyOfDoors) return false;
        return type != null ? type.equals(bus.type) : bus.type == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + qtyOfDoors;
        return result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQtyOfDoors() {
        return qtyOfDoors;
    }

    public void setQtyOfDoors(int qtyOfDoors) {
        this.qtyOfDoors = qtyOfDoors;
    }
}
