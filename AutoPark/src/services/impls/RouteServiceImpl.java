package services.impls;

import entities.Route;
import entities.Transport;
import repositories.RouteRepo;
import repositories.impl.TransportRepoImpl;
import services.RouteService;

import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    private final RouteRepo routeRepo;

    public RouteServiceImpl(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }

    @Override
    public boolean addRoute(Route route) {
        for (Route route1 : getAllRoutes()) {
            if (route.getId() == route1.getId()) {
                try {
                    throw new Exception("маршрут з ID " + route.getId() + " є у базі");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
        return routeRepo.addRoute(route);
    }

    @Override
    public boolean deleteRoute(int id) {
        List<Transport> transports = new TransportRepoImpl().getAllTransport();
        for (Transport transport : transports) {
            if (transport.getRoute().getId() == id) {
                System.out.println("Маршрут не видалено, на маршруті є транспорт");
                return false;
            }
        }
        if (routeRepo.deleteRoute(id)) {
            System.out.println("Маршрут з ID " + id + " успішно видалено");
            return true;
        } else {
            System.out.println("Маршрут з ID " + id + " не знайдено");
            return false;
        }
    }

    @Override
    public Route getRouteById(int id) {
        return routeRepo.getRouteById(id);
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
        List<Transport> getAllTransport = new TransportRepoImpl().getAllTransport();
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
}
