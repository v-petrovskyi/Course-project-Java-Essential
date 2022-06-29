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
        return routesList.add(route);
    }

    @Override
    public boolean deleteRoute(int id) {
        return routesList.remove(getRouteById(id));
    }

    @Override
    public Route getRouteById(int id) {
        for (Route route : routesList) {
            if (route.getId() == id) {
                return route;
            }
        }
        return null; // Тут краще спочатку перевірити, чи більше введений id ніж list.size(),
        // щоб не перебирати дарма. Також, повертати null не дуже, тоді краще його в Optional завернути додатково.
    }

    @Override
    public List<Route> getAllRoute() {
        return routesList;
    }
}
