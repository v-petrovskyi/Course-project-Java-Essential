import entities.*;
import repositories.DriverRepo;
import repositories.RouteRepo;
import repositories.TransportRepo;
import repositories.impl.DriverRepoImpl;
import repositories.impl.RouteRepoImpl;
import repositories.impl.TransportRepoImpl;
import services.DriverService;
import services.RouteService;
import services.TransportService;
import services.impls.DriverServiceImpl;
import services.impls.RouteServiceImpl;
import services.impls.TransportServiceImpl;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        console.start();
        console.addDefaultData();







    }
}
