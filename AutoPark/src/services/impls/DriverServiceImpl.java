package services.impls;

import entities.Driver;
import entities.Route;
import entities.Transport;
import repositories.DriverRepo;
import repositories.TransportRepo;
import repositories.impl.TransportRepoImpl;
import services.DriverService;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {
    DriverRepo driverRepo;

    public DriverServiceImpl(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public boolean addDriver(Driver driver) {
        return driverRepo.addDriver(driver);
    }

    @Override
    public boolean deleteDriver(int id) {
        List<Transport> allTransport = new TransportRepoImpl().getAllTransport();
        for (Transport transport : allTransport) {
            if (transport.getDriver().getId() == id) {
                try {
                    throw new Exception("driver is on a route");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        driverRepo.deleteDriver(id);
        return true;
    }

    @Override
    public Driver getDriverById(int id) {
        return driverRepo.getDriverById(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepo.getAllDrivers();
    }

    @Override
    public List<Driver> getAllDriversOnTheRoute(Route route) {
        List<Driver> allDriversOnTheRoute = new ArrayList<>();
        List<Transport> allTransport = new TransportRepoImpl().getAllTransport();
        for (Transport transport : allTransport) {
            if (transport.getRoute().equals(route)) {
                allDriversOnTheRoute.add(transport.getDriver());
            }
        }
        return allDriversOnTheRoute;
    }

    @Override
    public boolean AssignDriverToTransport(int driverId, int transportId) {
        Transport currentTransport = new TransportRepoImpl().getTransportById(transportId);
        Driver driver = getDriverById(driverId);
        if (driver.getDriverQualificationEnum().equals(currentTransport.getDriverQualificationEnum())) {
            currentTransport.setDriver(driver);
            return true;
        }
        return false;
    }
}
