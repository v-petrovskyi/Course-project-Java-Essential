package services.impls;

import entities.Route;
import entities.Transport;
import repositories.DriverRepo;
import repositories.RouteRepo;
import repositories.TransportRepo;
import services.RouteService;

import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    private final DriverRepo driverRepo;
    private final TransportRepo transportRepo;
    private final RouteRepo routeRepo;

    public RouteServiceImpl(DriverRepo driverRepo, TransportRepo transportRepo, RouteRepo routeRepo) {
        this.driverRepo = driverRepo;
        this.transportRepo = transportRepo;
        this.routeRepo = routeRepo;
    }

    @Override
    public boolean addRoute(Route route) {
        if (isPresent(route.getId())) {
            System.out.printf("Маршрут з id %d є у базі\n", route.getId());
            return false;
        }
        return routeRepo.addRoute(route);
    }

    @Override
    public boolean deleteRoute(int id) {
        if (isPresent(id)) {
            List<Transport> transports = transportRepo.getAllTransport();
            for (Transport transport : transports) {
                if (transport.getRoute() != null) {
                    if (transport.getRoute().getId() == id) {
                        System.out.println("Маршрут не видалено, на маршруті є транспорт");
                        return false;
                    }
                }
            }
            if (routeRepo.deleteRoute(id)) {
                System.out.println("Маршрут з ID " + id + " успішно видалено");
                return true;
            }
        }
        System.out.println("Маршрут з ID " + id + " не знайдено");
        return false;
    }

    @Override
    public Route getRouteById(int id) {
        if (isPresent(id)) {
            return routeRepo.getRouteById(id);
        }
        System.out.println("Маршрут з id " + id + " відсутній у базі");
        return null;
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepo.getAllRoute();
    }

    @Override
    public List<Route> getAllRoutesWithoutTransport() {
        List<Route> allRoutes = getAllRoutes();
        List<Route> allRoutesWithTransport = new ArrayList<>();
        List<Route> allRoutesWithoutTransport = new ArrayList<>();
        List<Transport> getAllTransport = transportRepo.getAllTransport();
        for (Transport transport : getAllTransport) {
            if (!allRoutesWithTransport.contains(transport.getRoute())) {
                allRoutesWithTransport.add(transport.getRoute());
            }
        }
        for (Route route : allRoutes) {
            if (!allRoutesWithTransport.contains(route)) {
                allRoutesWithoutTransport.add(route);
            }
        }
        return allRoutesWithoutTransport;
    }

    @Override
    public boolean isPresent(int routeId) {
        for (Route route : routeRepo.getAllRoute()) {
            if (route.getId() == routeId) {
                return true;
            }
        }
        return false;
    }
}
