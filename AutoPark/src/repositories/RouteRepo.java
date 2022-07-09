package repositories;


import entities.Route;

import java.util.List;

public interface RouteRepo {
    boolean addRoute(Route route);
    boolean deleteRoute(int id);
    Route getRouteById(int id);
    List<Route> getAllRoute();
    boolean isPresent(int routeId);
}
