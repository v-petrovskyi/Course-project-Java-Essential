package repositories.impl;

import entities.Driver;
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
        if (!isPresent(transport.getId())){
            return transportList.add(transport);
        }
        try {
            throw new Exception("транспорт з ID " + transport.getId() + " є у базі");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteTransport(int id) {
         return transportList.remove(getTransportById(id));
    }

    @Override
    public Transport getTransportById(int id) {
        if (isPresent(id)) {
            for (Transport transport : transportList) {
                if (transport.getId() == id) {
                    return transport;
                }
            }
        }
        System.out.println("Транспорт з id "+ id + " відсутній у базі");

        return null; // TODO Тут краще спочатку перевірити, чи більше введений id ніж list.size(),
        // щоб не перебирати дарма. Також, повертати null не дуже, тоді краще його в Optional завернути додатково.
    }

    @Override
    public List<Transport> getAllTransport() {
        return transportList;
    }

    @Override
    public boolean isPresent(int transportId) {
        for (Transport transport : transportList) {
            if (transport.getId() == transportId) {
                return true;
            }
        }
        return false;
    }
}
