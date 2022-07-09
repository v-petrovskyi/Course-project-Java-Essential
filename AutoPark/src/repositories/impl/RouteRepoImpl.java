package repositories.impl;

import entities.Route;
import repositories.RouteRepo;
import java.util.ArrayList;
import java.util.List;

public class RouteRepoImpl implements RouteRepo {
    private final List<Route> routesList;

    public RouteRepoImpl() {
        routesList = new ArrayList<>();
    }

    @Override
    public boolean addRoute(Route route) {
        if(!isPresent(route.getId())){
            return routesList.add(route);
        }
        try {
            throw new Exception("маршрут з ID " + route.getId() + " є у базі");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteRoute(int id) {
        return routesList.remove(getRouteById(id));
    }

    @Override
    public Route getRouteById(int id) {
        if (isPresent(id)) {
            for (Route route : routesList) {
                if (route.getId() == id) {
                    return route;
                }
            }
        }
        System.out.println("Маршрут з id "+ id + " відсутній у базі");

        return null; //TODO Тут краще спочатку перевірити, чи більше введений id ніж list.size(),
        // щоб не перебирати дарма. Також, повертати null не дуже, тоді краще його в Optional завернути додатково.
    }

    @Override
    public List<Route> getAllRoute() {
        return routesList;
    }

    @Override
    public boolean isPresent(int routeId) {
        for (Route route : routesList) {
            if (route.getId() == routeId) {
                return true;
            }
        }
        return false;

    }
}
