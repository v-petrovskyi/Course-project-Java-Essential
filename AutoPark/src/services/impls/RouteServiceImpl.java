package services.impls;

import entities.Route;
import entities.Transport;
import repositories.RouteRepo;
import services.RouteService;
import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteRepo routeRepo;

    @Override
    public boolean addRoute(Route route) {
        return routeRepo.addRoute(route);
    }

    @Override
    public boolean deleteRoute(int id) {
        List<Transport> transports = new TransportServiceImpl().getAllTransport();
        for (Transport transport : transports) {
            if (transport.getRoute().getId()==id){
                System.out.println("Маршрут не видалено, на маршруті є транспорт");
                return false;
            }
        }
        return routeRepo.deleteRoute(id);
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
        List<Transport> getAllTransport = new TransportServiceImpl().getAllTransport();
        for (Transport transport : getAllTransport) {
            if (!allRoutesWithTransport.contains(transport.getRoute())){
                allRoutesWithTransport.add(transport.getRoute());
            }
        }
        for (Route route : allRoutes) {
            if (!allRoutesWithTransport.contains(route)){
                allRoutesWithoutTransport.add(route);
            }
        }
        return allRoutesWithoutTransport;
    }
}