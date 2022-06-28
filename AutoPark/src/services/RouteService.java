package services;

import entities.Route;

import java.util.List;

public interface RouteService {
    boolean addRoute(Route route);
    boolean deleteRoute(int id);
    Route getRouteById(int id);
    List<Route> getAllRoutes();
    List<Route> getAllRoutesWithoutTransport();
}
