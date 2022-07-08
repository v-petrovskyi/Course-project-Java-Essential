package services;


import entities.Transport;
import java.util.List;

public interface TransportService {
    boolean addTransport(Transport transport);
    boolean deleteTransport(int id);
    Transport getTransportById(int id);
    List<Transport> getAllTransport();
    List<Transport> getListOfTransportByMark(String mark);
    List<Transport> getListOfTransportWithoutDriver();
    boolean transportToRoute(int transportId, int routeId);
    boolean removeTransportFromTheRoute(int id);

}
