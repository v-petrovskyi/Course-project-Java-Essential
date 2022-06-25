package services;

import com.sun.jdi.connect.Transport;
import repositories.TransportRepo;

public interface TransportService {
    boolean add(Transport transport);
    boolean remove(Transport transport);

}
