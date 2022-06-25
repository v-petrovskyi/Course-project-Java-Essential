import entities.*;
import repositories.TransportRepo;
import repositories.impl.TransportRepoImpl;

public class Main {
    public static void main(String[] args) {
        TransportRepo transportRepo = new TransportRepoImpl();
        Driver driver = new Driver(1, "Vasja", "Petrov", "4231354", DriverQualificationEnum.TRAM_DRIVER);
        Route route =new Route(1, "Lviv", "Ternopil");

        transportRepo.addTransport(new Transport(1,"MAN",22, DriverQualificationEnum.BUS_DRIVER));
        transportRepo.addTransport(new Tram(2,"RENAULT",25, DriverQualificationEnum.TRAM_DRIVER, 5));
//        System.out.println(transportRepo.deleteTransport(1));
        System.out.println(transportRepo.getAllTransport());



    }
}
