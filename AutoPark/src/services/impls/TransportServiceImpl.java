package services.impls;

import entities.Route;
import repositories.DriverRepo;
import repositories.RouteRepo;
import repositories.TransportRepo;
import services.TransportService;
import entities.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportServiceImpl implements TransportService {
    private final DriverRepo driverRepo;
    private final TransportRepo transportRepo;
    private final RouteRepo routeRepo;

    public TransportServiceImpl(DriverRepo driverRepo, TransportRepo transportRepo, RouteRepo routeRepo) {
        this.driverRepo = driverRepo;
        this.transportRepo = transportRepo;
        this.routeRepo = routeRepo;
    }

    @Override
    public boolean addTransport(Transport transport) {
        if (isPresent(transport.getId())) {
            System.out.printf("Транспорт з id %d є у базі\n", transport.getId());
            return false;
        }
        return transportRepo.addTransport(transport);
    }

    @Override
    public boolean deleteTransport(int id) {
        if (isPresent(id)) {
            if (getTransportById(id).getDriver() == null) {
                System.out.println("Транспорт " + id + "успішно видалено");
                return transportRepo.deleteTransport(id);
            }
            System.out.println("Транспорт не видалено. На даному транспорі є водій, \nперед видаленням зніміть водія з транспорту");
            return false;
        }
        System.out.println("Транспорт з ID " + id + " відсутній у базі");
        return false;
    }

    @Override
    public Transport getTransportById(int id) {
        if (isPresent(id)) {
            return transportRepo.getTransportById(id);
        }
        return null;
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
            if (mark.equalsIgnoreCase(transport.getBrand())) {
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
        if (isPresent(transportId) & (routeRepo.getRouteById(routeId)!=null)) {
            Transport transport = getTransportById(transportId);
            if (transport.getDriver() != null) {
                Route route = routeRepo.getRouteById(routeId);
                transport.setRoute(route);
                System.out.printf("Транспорт ID %d успішно назначено на маршрут ID %d\n\n", transportId, routeId);
                return true;
            } else if (transport.getDriver() == null) {
                System.out.println("Спершу потрібно назначити водія на даний транспорт");
                return false;
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

    @Override
    public boolean isPresent(int transportId) {
        for (Transport transport : transportRepo.getAllTransport()) {
            if (transport.getId() == transportId) {
                return true;
            }
        }
        return false;
    }
}
