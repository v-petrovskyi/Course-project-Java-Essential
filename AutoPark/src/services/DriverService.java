package services;

import entities.Driver;
import entities.Route;

import java.util.List;

public interface DriverService {
    boolean addDriver(Driver driver);
    boolean deleteDriver(int id);
    Driver getDriverById(int id);
    List<Driver> getAllDrivers();
    List<Driver> getAllDriversOnTheRoute(Route route);
    boolean AssignDriverToTransport (int driverId, int transportId);

}
