package entities;


import java.util.Objects;

public class Transport {
    private int id;
    private String brand;
    private int passengers;
    private Driver driver;
    private Route route;
    private DriverQualificationEnum driverQualificationEnum;

    public Transport(int id, String brand, int passengers, DriverQualificationEnum driverQualificationEnum) {
        this.id = id;
        this.brand = brand;
        this.passengers = passengers;
        this.driverQualificationEnum = driverQualificationEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public DriverQualificationEnum getDriverQualificationEnum() {
        return driverQualificationEnum;
    }

    public void setDriverQualificationEnum(DriverQualificationEnum driverQualificationEnum) {
        this.driverQualificationEnum = driverQualificationEnum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transport{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", passengers=").append(passengers);
        sb.append(", driver=").append(driver);
        sb.append(", route=").append(route);
        sb.append(", driverQualificationEnum=").append(driverQualificationEnum);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (id != transport.id) return false;
        if (passengers != transport.passengers) return false;
        if (!brand.equals(transport.brand)) return false;
        if (!driver.equals(transport.driver)) return false;
        if (!route.equals(transport.route)) return false;
        return driverQualificationEnum == transport.driverQualificationEnum;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + brand.hashCode();
        result = 31 * result + passengers;
        result = 31 * result + driver.hashCode();
        result = 31 * result + route.hashCode();
        result = 31 * result + driverQualificationEnum.hashCode();
        return result;
    }
}
