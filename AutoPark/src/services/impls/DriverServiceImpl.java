package services.impls;

import entities.Driver;
import entities.Route;
import entities.Transport;
import repositories.DriverRepo;
import repositories.TransportRepo;
import repositories.impl.RouteRepoImpl;
import repositories.impl.TransportRepoImpl;
import services.DriverService;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {
    private final DriverRepo driverRepo;

    public DriverServiceImpl(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public boolean addDriver(Driver driver) {
        for (Driver driver1 : getAllDrivers()) {
            if (driver.getId() == driver1.getId()) {
                try {
                    throw new Exception("водій з ID " + driver.getId() + " є у базі");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
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
        // додати перевірку чи існує водій з даним ID
        return driverRepo.deleteDriver(id);
    }

    @Override
    public Driver getDriverById(int id) {
        return driverRepo.getDriverById(id);
    }

    @Override
    public List<Driver> getAllDriversBySurname(String surname) {
        List<Driver> allDriversBySurname = new ArrayList<>();
        List<Driver> allDrivers = getAllDrivers();
        for (Driver driver : allDrivers) {
            if (driver.getSurname().equals(surname)){
                allDriversBySurname.add(driver);
            }
        }
        return allDriversBySurname;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepo.getAllDrivers();
    }

    @Override
    public List<Driver> getAllDriversOnTheRoute(int routeId) {
        Route route = new RouteRepoImpl().getRouteById(routeId);
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
    public List<Driver> getAllDriversWithoutTransport() {
        List<Driver> allDriversWithoutTransport = new ArrayList<>();
        List<Driver> allDriversWithTransport = new ArrayList<>();
        List<Transport> allTransport = new TransportRepoImpl().getAllTransport();
        for (Transport transport : allTransport) {
            if (transport.getDriver() != null){
                allDriversWithTransport.add(transport.getDriver());
            }
        }
        List<Driver> allDrivers = getAllDrivers();
        for (Driver driver : allDrivers) {
            if(!allDriversWithTransport.contains(driver)){
                allDriversWithoutTransport.add(driver);
            }
        }
        return allDriversWithoutTransport;
    }

    @Override
    public boolean assignDriverToTransport(int driverId, int transportId) {
        Transport currentTransport = new TransportRepoImpl().getTransportById(transportId);
        Driver driver = getDriverById(driverId);
        if (driver.getDriverQualificationEnum().equals(currentTransport.getDriverQualificationEnum())) {
            currentTransport.setDriver(driver);
            return true;
        }
        return false;
    }
}
