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
        routesList.add(route);
        return true;
    }

    @Override
    public boolean deleteRoute(int id) {
        routesList.remove(getRouteById(id));
        return true;
    }

    @Override
    public Route getRouteById(int id) {
        for (Route route : routesList) {
            if(route.getId()==id){
                return route;
            }
        }
        return null;
    }

    @Override
    public List<Route> getAllRoute() {
        return routesList;
    }
}
