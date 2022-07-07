package services;

import entities.Driver;
import entities.Route;

import java.util.List;

public interface DriverService {
    boolean addDriver(Driver driver);
    boolean deleteDriver(int id);
    Driver getDriverById(int id);
    List<Driver> getAllDriversBySurname(String surname);
    List<Driver> getAllDrivers();
    List<Driver> getAllDriversOnTheRoute(Route route);
    List<Driver> getAllDriversWithoutTransport();
    boolean AssignDriverToTransport (int driverId, int transportId);

}
