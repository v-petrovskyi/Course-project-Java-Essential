package repositories.impl;


import entities.Transport;
import repositories.TransportRepo;
import java.util.ArrayList;
import java.util.List;


public class TransportRepoImpl implements TransportRepo {
    private final List<Transport> transportList;

    public TransportRepoImpl() {
        this.transportList = new ArrayList<>();
    }

    @Override
    public boolean addTransport(Transport transport) {
        transportList.add(transport);
        return true;
    }

    @Override
    public boolean deleteTransport(int id) {
        transportList.remove(getTransportById(id));
        return true;
    }

    @Override
    public Transport getTransportById(int id) {
        Transport tempTr;
        for (Transport transport : transportList) {
            int idCurrentTransport = transport.getId();
            if (idCurrentTransport.)
        }
        return null;
    }

    @Override
    public List<Transport> getAllTransport() {
        return null;
    }
}
