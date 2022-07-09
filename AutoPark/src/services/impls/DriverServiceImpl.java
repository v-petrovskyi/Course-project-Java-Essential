package services.impls;

import entities.Driver;
import entities.Route;
import entities.Transport;
import repositories.DriverRepo;
import repositories.RouteRepo;
import repositories.TransportRepo;
import services.DriverService;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {
    private final DriverRepo driverRepo;
    private final TransportRepo transportRepo;
    private final RouteRepo routeRepo;


    public DriverServiceImpl(DriverRepo driverRepo, TransportRepo transportRepo, RouteRepo routeRepo) {
        this.driverRepo = driverRepo;
        this.transportRepo = transportRepo;
        this.routeRepo = routeRepo;

    }

    @Override
    public boolean addDriver(Driver driver) {
        return driverRepo.addDriver(driver);
    }

    @Override
    public boolean deleteDriver(int id) {
        if (driverRepo.isPresent(id)) {
            List<Transport> allTransport = transportRepo.getAllTransport();
            for (Transport transport : allTransport) {
                if (transport.getDriver() != null) {
                    if (transport.getDriver().getId() == id) {
                        try {
                            throw new Exception("driver is on a route");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

            }
            return driverRepo.deleteDriver(id);
        }
        return false;
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
            if (driver.getSurname().equalsIgnoreCase(surname)) {
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
        List<Driver> allDriversOnTheRoute = new ArrayList<>();
        if (routeRepo.isPresent(routeId)) {
            Route route = routeRepo.getRouteById(routeId);
            List<Transport> allTransport = transportRepo.getAllTransport();
            for (Transport transport : allTransport) {
                if (transport.getRoute()!=null){
                    if (transport.getRoute().equals(route)) {
                        allDriversOnTheRoute.add(transport.getDriver());
                    }
                }
            }
        } else {
            System.out.println("Маршрут відсутній");
        }
        return allDriversOnTheRoute;
    }

    @Override
    public List<Driver> getAllDriversWithoutTransport() {
        List<Driver> allDriversWithoutTransport = new ArrayList<>();
        List<Driver> allDriversWithTransport = new ArrayList<>();
        List<Transport> allTransport = transportRepo.getAllTransport();
        for (Transport transport : allTransport) {
            if (transport.getDriver() != null) {
                allDriversWithTransport.add(transport.getDriver());
            }
        }
        List<Driver> allDrivers = getAllDrivers();
        for (Driver driver : allDrivers) {
            if (!allDriversWithTransport.contains(driver)) {
                allDriversWithoutTransport.add(driver);
            }
        }
        return allDriversWithoutTransport;
    }

    @Override
    public boolean assignDriverToTransport(int driverId, int transportId) {
        Driver driver = driverRepo.getDriverById(driverId);
        Transport transport = transportRepo.getTransportById(transportId);
        if (driver == null || transport == null) {
            System.out.printf("Транспорт з ID %d не було закріплено за водієм з ID %d,\n водій або транспорт не існує\n", transportId, driverId);
            return false;
        }
        if (driver.getDriverQualificationEnum().equals(transport.getDriverQualificationEnum())) {
            transport.setDriver(driver);
            System.out.printf("Водій з ID %d успішно закріплений за транспортом ID %d.\n ", driver.getId(), transport.getId());
            return true;
        } else {
            System.out.printf("Водій з ID %d не був закріплений за транспортом ID %d,\n водій не має кваліфікації на даний транспорт\n", driver.getId(), transport.getId());
            return false;
        }
    }
}
