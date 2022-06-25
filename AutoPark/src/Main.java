import entities.Driver;
import entities.DriverQualificationEnum;
import entities.Route;
import entities.Transport;
import repositories.TransportRepo;
import repositories.impl.TransportRepoImpl;

public class Main {
    public static void main(String[] args) {
        TransportRepo transportRepo = new TransportRepoImpl();
        Driver driver = new Driver(1, "Vasja", "Petrov", "4231354", DriverQualificationEnum.TRAM_DRIVER);
        Route route =new Route(1, "Lviv", "Ternopil");

        transportRepo.addTransport(new Transport(1,"MAN",22, driver, route,DriverQualificationEnum.BUS_DRIVER));
        System.out.println(transportRepo.getAllTransport());
        System.out.println(transportRepo.getTransportById(0));


    }
}
