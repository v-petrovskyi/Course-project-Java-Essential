package services.impls;

import entities.Driver;
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
        return routeRepo.addRoute(route);
    }

    @Override
    public boolean deleteRoute(int id) {
        if (routeRepo.isPresent(id)){
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
            }
        }
        System.out.println("Маршрут з ID " + id + " не знайдено");
        return false;
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
