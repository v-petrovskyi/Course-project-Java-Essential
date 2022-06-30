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

import java.util.Scanner;

public class Console {
    TransportRepo transportRepo = new TransportRepoImpl();
    TransportService transportService = new TransportServiceImpl(transportRepo);
    DriverRepo driverRepo = new DriverRepoImpl();
    DriverService driverService = new DriverServiceImpl(driverRepo);
    RouteRepo routeRepo = new RouteRepoImpl();
    RouteService routeService = new RouteServiceImpl(routeRepo);

    public void addDefaultData() {
        transportService.add(new Bus(1,"MAN",50, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(2,"Electron",48, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(3,"TATRA",25, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(4, "Mercedes-Benz", 51, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(5,"Богдан", 15, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(6, "Ikarus", 70, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(7, "Temsa", 46, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(8, "Volvo", 60, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(9,"Богдан", 15, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(10,"Electron",48, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(11,"Electron",48, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(12,"MAN",50, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(13, "Mercedes-Benz", 60, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(14, "Mercedes-Benz", 55, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Tram(15,"Electron",150,DriverQualificationEnum.TRAM_DRIVER,5));
        transportService.add(new Tram(16,"Electron",180,DriverQualificationEnum.TRAM_DRIVER,6));
        transportService.add(new Tram(17,"Electron",120,DriverQualificationEnum.TRAM_DRIVER,3));
        transportService.add(new Tram(18,"Inekon Trams",100,DriverQualificationEnum.TRAM_DRIVER,2));
        transportService.add(new Tram(19,"Inekon Trams",120,DriverQualificationEnum.TRAM_DRIVER,3));
        transportService.add(new Tram(20,"Inekon Trams",150,DriverQualificationEnum.TRAM_DRIVER,6));

        driverService.addDriver(new Driver(1, "Ivan", "Petrenko","6546546",DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(2, "John", "Smith","46345",DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(3, "Taras", "Evans","611312",DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(4, "William", "Green","55498",DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(5, "Mike", "Baker","51213",DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(6, "Jane", "Thomas","001235",DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(7, "Torben", "Edwards","23132156",DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(8, "Stew", "Roberts","54654",DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(9, "Vasyl", "Wilson","65641617",DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(10, "Olga", "Davies","65125489",DriverQualificationEnum.BUS_DRIVER));

        routeService.addRoute(new Route(1, "Ivana Vyhovskoho St", "Naukova St"));
        routeService.addRoute(new Route(2, "Shchyretska St", "Volodymyra Velykoho St"));
        routeService.addRoute(new Route(3, "Knyahyni Ol'hy St", "VLyzhviarska St"));
        routeService.addRoute(new Route(4, "Petra Doroshenka St", "Zamkova St"));
        routeService.addRoute(new Route(5, "Zamkova St", "Poltv'yana St"));
    }

    public void show(){
        System.out.println(transportService.getAllTransport());
        System.out.println(driverService.getAllDrivers());
        System.out.println(routeService.getAllRoutes());
    }

    public void start() {
        System.out.println("""
                \tВиберіть один з пунктів меню
                1 меню маршрутів
                2 меню транспортів
                3 меню водіїв
                4 добавити тестові дані у базу даних
                q вийти з програми""");
        switch (scanner()){
            case "1":
                routesMenu();
                break;
            case "2":
                transportsMenu();
                break;
            case "3":
                driversMenu();
                break;
            case "4":
                addDefaultData();
                System.out.println("дані успішно додано");
                start();
                break;
            case "q":
                exit();
                break;
            default:
                start();
                break;
        }
    }

    private String scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private void exit() {
        System.out.println("Exit...");
        System.exit(0);
    }

    private void routesMenu() {
        System.out.println("""
                \tМеню маршрутів
                1 добавити маршрут
                2 видалити маршрут
                3 вивести маршрут по Id
                4 вивести усі маршрути
                5 перейти у попереднє меню
                q вийти з програми""");
        switch (scanner()){
            case "1":
 //               routeService.addRoute(); // дописати функціонал!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                break;
            case "2":
                System.out.println("Ведіть ID маршруту який ви хочете видалити");
                int id = Integer.parseInt(scanner());
                routeService.deleteRoute(id);
                break;
            case "3":
                printChosenRoute();
                break;
            case "4":
                printAllRoutes();
            case "5":
                start();
                break;
            case "q":
                exit();
                break;
            default:
                routesMenu();
                break;
        }
        routesMenu();
    }

    private void printChosenRoute() {
        System.out.println("Ведіть ID маршруту який ви хочете вивести на екран");
        int id2 = Integer.parseInt(scanner());
        TableList tableListRoutes = new TableList(3,"ID", "Start Place","End Place");
        tableListRoutes.addRow(String.valueOf(routeService.getRouteById(id2).getId()),
                               routeService.getRouteById(id2).getStartPlace(),
                               routeService.getRouteById(id2).getEndPlace());
        tableListRoutes.print();
    }

    private void printAllRoutes() {
        System.out.println("\tУсі маршрути");
        TableList tableListRoutes = new TableList(3,"ID", "Start Place","End Place");
        for (Route allRoute : routeService.getAllRoutes()) {
            tableListRoutes.addRow(String.valueOf(allRoute.getId()),
                                   allRoute.getStartPlace(),
                                   allRoute.getEndPlace());
        }
        tableListRoutes.print();
    }

    private void transportsMenu() { // написати функціонал
        start();

    }

    private void driversMenu() { // написати функціонал
        start();

    }
}
