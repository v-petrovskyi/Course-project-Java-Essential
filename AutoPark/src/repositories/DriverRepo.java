package repositories;

import entities.Driver;

import java.util.List;

public interface DriverRepo {
    boolean addDriver(Driver driver);
    boolean deleteDriver(int id);
    Driver getDriverById(int id);
    List<Driver> getAllDrivers();
    boolean isPresent(int id);
}
