package services.impls;

import entities.Driver;
import entities.Route;
import repositories.TransportRepo;
import repositories.impl.DriverRepoImpl;
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
    public boolean addTransport(Transport transport) {
        return transportRepo.addTransport(transport);
    }

    @Override
    public boolean deleteTransport(int id) {
        if (transportRepo.isPresent(id)){
            if (getTransportById(id).getDriver() == null) {
                System.out.println("Транспорт "+ id + "успішно видалено");
                return transportRepo.deleteTransport(id);
            }
            System.out.println("Транспорт не видалено. На даному транспорі є водій, \nперед видаленням зніміть водія з транспорту");
            return false;
        }
        System.out.println("Транспорт з ID " + id + " відсутній у базі" );
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
        if (transportRepo.isPresent(transportId)&(new RouteRepoImpl().isPresent(routeId))){
            Transport transport = getTransportById(transportId);
            if (transport.getDriver() != null) {
                Route route = new RouteRepoImpl().getRouteById(routeId);
                transport.setRoute(route);
                return true;
            }
        }
        System.out.printf("Транспорт з ID %d не був поставлено на маршрут з ID %d,\n маршрут або транспорт не існує\n", transportId, routeId);
        return false;
    }

    @Override
    public boolean removeTransportFromTheRoute(int id) {
        transportRepo.getTransportById(id).setRoute(null);
        return true;
    }
}
