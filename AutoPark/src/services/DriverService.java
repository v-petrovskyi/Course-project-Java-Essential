package services;

import entities.Driver;
import entities.Transport;

import java.util.List;

public interface DriverService {
    boolean addDriver(Driver driver);
    boolean deleteDriver(int id);
    Driver getDriverById(int id);
    List<Driver> getAllDriversBySurname(String surname);
    List<Driver> getAllDrivers();
    List<Driver> getAllDriversOnTheRoute(int routeId);
    List<Driver> getAllDriversWithoutTransport();
    boolean assignDriverToTransport(Driver driver, Transport transport);
}
