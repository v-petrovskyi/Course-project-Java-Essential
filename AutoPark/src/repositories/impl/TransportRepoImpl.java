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
            return transportList.add(transport);
    }

    @Override
    public boolean deleteTransport(int id) {
         return transportList.remove(getTransportById(id));
    }

    @Override
    public Transport getTransportById(int id) {
            for (Transport transport : transportList) {
                if (transport.getId() == id) {
                    return transport;
                }
            }
        return null; // TODO Тут краще спочатку перевірити, чи більше введений id ніж list.size(),
        // щоб не перебирати дарма. Також, повертати null не дуже, тоді краще його в Optional завернути додатково.
    }

    @Override
    public List<Transport> getAllTransport() {
        return transportList;
    }
}
