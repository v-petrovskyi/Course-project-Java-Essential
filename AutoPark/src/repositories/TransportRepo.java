package repositories;

import entities.Transport;
import java.util.List;

public interface TransportRepo {
    boolean addTransport(Transport transport);
    boolean deleteTransport(int id);
    Transport getTransportById(int id);
    List<Transport> getAllTransport();
    boolean isPresent(int transportId);
}
