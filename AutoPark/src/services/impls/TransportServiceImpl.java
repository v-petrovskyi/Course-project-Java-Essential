package services.impls;

import entities.Route;
import repositories.TransportRepo;
import repositories.impl.RouteRepoImpl;
import services.TransportService;
import entities.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportServiceImpl implements TransportService {
    private final TransportRepo transportRepo;

    public TransportServiceImpl(TransportRepo transportRepo) {
        this.transportRepo = transportRepo;
    }

    @Override
    public boolean add(Transport transport) {
        transportRepo.addTransport(transport);
        return true;
    }

    @Override
    public boolean deleteTransport(int id) {
        if (getTransportById(id).getDriver() == null) {
            transportRepo.deleteTransport(id);
            return true;
        }
        return false;
    }

    @Override
    public Transport getTransportById(int id) {
        return transportRepo.getTransportById(id);
    }

    @Override
    public List<Transport> getAllTransport() {
        return transportRepo.getAllTransport();
    }

    @Override
    public List<Transport> getListOfTransportByMark(String mark) {
        List<Transport> tempList = transportRepo.getAllTransport();
        List<Transport> listByMark = new ArrayList<>();
        for (Transport transport : tempList) {
            if (mark.equals(transport.getBrand())) {
                listByMark.add(transport);
            }
        }
        return listByMark;
    }

    @Override
    public List<Transport> getListOfTransportWithoutDriver() {
        List<Transport> tempList = transportRepo.getAllTransport();
        List<Transport> listOfTransportWithoutDriver = new ArrayList<>();
        for (Transport transport : tempList) {
            if (transport.getDriver() == null) {
                listOfTransportWithoutDriver.add(transport);
            }
        }
        return listOfTransportWithoutDriver;
    }

    @Override
    public boolean transportToRoute(int transportId, int routeId) {
        Transport transport = getTransportById(transportId);
        if (transport.getDriver() != null) {
            Route route = new RouteRepoImpl().getRouteById(routeId);
            transport.setRoute(route);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeTransportFromTheRoute(int id) {
        transportRepo.getTransportById(id).setRoute(null);
        return true;
    }
}
