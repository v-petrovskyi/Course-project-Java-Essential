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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Console {
    TransportRepo transportRepo = new TransportRepoImpl();
    TransportService transportService = new TransportServiceImpl(transportRepo);
    DriverRepo driverRepo = new DriverRepoImpl();
    DriverService driverService = new DriverServiceImpl(driverRepo);
    RouteRepo routeRepo = new RouteRepoImpl();
    RouteService routeService = new RouteServiceImpl(routeRepo);

    public void addDefaultData() {
        transportService.add(new Bus(1, "MAN", 50, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(2, "Electron", 48, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(3, "TATRA", 25, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(4, "Mercedes-Benz", 51, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(5, "Богдан", 15, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(6, "Ikarus", 70, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(7, "Temsa", 46, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(8, "Volvo", 60, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(9, "Богдан", 15, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(10, "Electron", 48, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(11, "Electron", 48, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(12, "MAN", 50, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(13, "Mercedes-Benz", 60, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Bus(14, "Mercedes-Benz", 55, DriverQualificationEnum.BUS_DRIVER));
        transportService.add(new Tram(15, "Electron", 150, DriverQualificationEnum.TRAM_DRIVER, 5));
        transportService.add(new Tram(16, "Electron", 180, DriverQualificationEnum.TRAM_DRIVER, 6));
        transportService.add(new Tram(17, "Electron", 120, DriverQualificationEnum.TRAM_DRIVER, 3));
        transportService.add(new Tram(18, "Inekon Trams", 100, DriverQualificationEnum.TRAM_DRIVER, 2));
        transportService.add(new Tram(19, "Inekon Trams", 120, DriverQualificationEnum.TRAM_DRIVER, 3));
        transportService.add(new Tram(20, "Inekon Trams", 150, DriverQualificationEnum.TRAM_DRIVER, 6));

        driverService.addDriver(new Driver(1, "Ivan", "Petrenko", "6546546", DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(2, "John", "Smith", "46345", DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(3, "Taras", "Evans", "611312", DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(4, "William", "Green", "55498", DriverQualificationEnum.TRAM_DRIVER));
        driverService.addDriver(new Driver(5, "Mike", "Baker", "51213", DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(6, "Jane", "Thomas", "001235", DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(7, "Torben", "Edwards", "23132156", DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(8, "Stew", "Roberts", "54654", DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(9, "Vasyl", "Wilson", "65641617", DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(10, "Olga", "Davies", "65125489", DriverQualificationEnum.BUS_DRIVER));
        driverService.addDriver(new Driver(11, "Vasyl", "Davies", "5564123156", DriverQualificationEnum.BUS_DRIVER));

        routeService.addRoute(new Route(1, "Ivana Vyhovskoho St", "Naukova St"));
        routeService.addRoute(new Route(2, "Shchyretska St", "Volodymyra Velykoho St"));
        routeService.addRoute(new Route(3, "Knyahyni Ol'hy St", "VLyzhviarska St"));
        routeService.addRoute(new Route(4, "Petra Doroshenka St", "Zamkova St"));
        routeService.addRoute(new Route(5, "Zamkova St", "Poltv'yana St"));

        System.out.println("дані успішно додано");
    }

    public void show() {
        System.out.println(transportService.getAllTransport());
        System.out.println(driverService.getAllDrivers());
        printRoutes("\tУсі маршрути", routeService.getAllRoutes());

    }

    public void start() {
        System.out.println("""
                \tВиберіть один з пунктів меню
                1 меню маршрутів
                2 меню транспортів
                3 меню водіїв
                4 добавити тестові дані у базу даних
                q вийти з програми""");
        switch (readFromConsole()) {
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
                break;
            case "q":
                exit();
                break;
            default:
                start();
                break;
        }
        start();
    }

    private void routesMenu() {
        System.out.println("""
                \tМеню маршрутів
                1 добавити маршрут
                2 видалити маршрут
                3 вивести маршрут по Id
                4 вивести усі маршрути
                5 вивести маршрути без транспорту
                6 перейти у попереднє меню
                q вийти з програми""");
        switch (readFromConsole()) {
            case "1": // добавити маршрут
                inputNewRoute();
                break;
            case "2": //видалити маршрут
                deletingRoute();
                break;
            case "3": //вивести маршрут по Id
                printChosenRoute();
                routesMenu();
                break;
            case "4": //вивести усі маршрути
                printRoutes("\tУсі маршрути", routeService.getAllRoutes());
                break;
            case "5": //вивести маршрути без транспорту
                printRoutes("\tМаршрути без транспорту", routeService.getAllRoutesWithoutTransport());
                break;
            case "6": //перейти у попереднє меню
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

    private String readFromConsole() {
        BufferedReader bufferedReader = null;
        String inputData;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputData = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {   // якщо закривати  bufferedReader то вилітає Exception.
//            if (bufferedReader != null) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
        return inputData;
    }

    private void exit() {
        System.out.println("Exit...");
        System.exit(0);
    }

    private void printRoutes(String title, List<Route> routeService) {
        System.out.println(title);
        TableList tableListRoutes = new TableList(3, "ID", "Start Place", "End Place");
        for (Route allRoute : routeService) {
            tableListRoutes.addRow(String.valueOf(allRoute.getId()),
                    allRoute.getStartPlace(),
                    allRoute.getEndPlace());
        }
        tableListRoutes.print();
        routesMenu();
    }

    private void deletingRoute() {
        System.out.println("Ведіть ID маршруту який ви хочете видалити");
        int id = Integer.parseInt(readFromConsole());
        routeService.deleteRoute(id);
    }

    private void inputNewRoute() {
        System.out.println("""
                Введіть дані маршруту, використовуйте "|" в якості розділювача
                                        
                ID | Start Place         | End Place             """);
        String[] slitByBlock = readFromConsole().split("\\|");
        int id = Integer.parseInt(slitByBlock[0].trim());
        String startPlace = slitByBlock[1].trim();
        String endPlace = slitByBlock[2].trim();
        Route newRoute = new Route(id, startPlace, endPlace);
        if (routeService.addRoute(newRoute)) {
            System.out.println("внесено новий маршрут");
            printOneRoute(id);
        }

        System.out.println("""
                1 внести ще один маршрут
                2 повернутися у меню маршрутів
                3 у головне меню
                q вийти""");
        switch (readFromConsole()) {
            case "1":
                inputNewRoute();
                break;
            case "2":
                routesMenu();
                break;
            case "3":
                start();
                break;
            case "q":
                exit();
                break;
            default:
                routesMenu();
                break;
        }
    }

    private void printOneRoute(int id) {
        TableList tableListRoutes = new TableList(3, "ID", "Start Place", "End Place");
        tableListRoutes.addRow(String.valueOf(routeService.getRouteById(id).getId()),
                routeService.getRouteById(id).getStartPlace(),
                routeService.getRouteById(id).getEndPlace());
        tableListRoutes.print();
        System.out.println();
    }

    private void printChosenRoute() {
        System.out.println("Ведіть ID маршруту який ви хочете вивести на екран");
        int id = Integer.parseInt(readFromConsole());
        printOneRoute(id);
    }

    private void transportsMenu() { // написати функціонал
        start();

    }

    private void driversMenu() {
        System.out.println("""
                \tМеню водіїв
                1 додати водія
                2 видалити водія
                3 вивести на екран водія по ID
                4 вивести водіїв із вказаним прізвищем
                5 вивести на екран усіх водіїв
                6 вивести усіх водіїв на вказаному маршруті
                7 вивести усіх водіїв без транспорту
                8 назначити водія на транспорт
                9 перейти у попереднє меню
                q вийти з програми""");
        switch (readFromConsole()) {
            case "1": //додати водія
                inputNewDriver();
                break;
            case "2": //видалити водія
                deletingDriver();
                break;
            case "3": //вивести на екран водія по ID
                printChosenDriver();
                break;
            case "4": //вивести водіїв із вказаним прізвищем
                printDriversWithChosenSurname();
                break;
            case "5": //вивести на екран усіх водіїв
                printDrivers("\tУсі водії", driverService.getAllDrivers());
                break;
            case "6": //вивести усіх водіїв на вказаному маршруті
                printDriversOnChosenRoute();
                break;
            case "7": //вивести усіх водіїв без транспорту
                printDrivers("\tУсі водії без транспорту", driverService.getAllDriversWithoutTransport());
                break;
            case "8": //назначити водія на транспорт
                driverToTransport();
                break;
            case "9": //перейти у попереднє меню
                start();
                break;
            case "q":
                exit();
                break;
        }
        driversMenu();
    }

    private void inputNewDriver() {
        System.out.println("""
                Введіть дані маршруту, використовуйте "|" в якості розділювача
                                        
                 ID | Name  | Surname | Phone number | Driver license (Автобус або Трамвай)""");
        String[] slitByBlock = readFromConsole().split("\\|");
        int id = Integer.parseInt(slitByBlock[0].trim());
        String name = slitByBlock[1].trim();
        String surname = slitByBlock[2].trim();
        String phoneNumber = slitByBlock[3].trim();
        String driverQualification = slitByBlock[4].trim();
        DriverQualificationEnum driverQualificationEnum = null;
        if (driverQualification.equalsIgnoreCase(DriverQualificationEnum.TRAM_DRIVER.getType())){
            driverQualificationEnum = DriverQualificationEnum.TRAM_DRIVER;
        } else if (driverQualification.equalsIgnoreCase(DriverQualificationEnum.BUS_DRIVER.getType())){
            driverQualificationEnum = DriverQualificationEnum.BUS_DRIVER;
        }
        Driver newDriver = new Driver(id,name,surname,phoneNumber, driverQualificationEnum);
        if (driverService.addDriver(newDriver)) {
            System.out.println("внесено нового водія");
            printOneDriver(id);
        }
        System.out.println("""
                1 внести ще одного водія
                2 повернутися у меню водіїв
                3 у головне меню
                q вийти""");
        switch (readFromConsole()) {
            case "1":
                inputNewDriver();
                break;
            case "2":
                driversMenu();
                break;
            case "3":
                start();
                break;
            case "q":
                exit();
                break;
            default:
                driversMenu();
                break;
        }
    }

    private void printOneDriver(int id) {
        TableList tableListDrivers = new TableList("ID", "Name", "Surname", "Phone number", "Driver license");
        tableListDrivers.addRow(
                String.valueOf(driverService.getDriverById(id).getId()),
                driverService.getDriverById(id).getName(),
                driverService.getDriverById(id).getSurname(),
                driverService.getDriverById(id).getPhoneNumber(),
                driverService.getDriverById(id).getDriverQualificationEnum().getType());
        tableListDrivers.print();
        System.out.println();
    }

    private void printDriversOnChosenRoute() {
        System.out.println("Введіть ID маршруту");
        int route = Integer.parseInt(readFromConsole().trim());
        printDrivers("\tУсі водії на маршруті з ID " + route, driverService.getAllDriversOnTheRoute(route));
    }

    private void printDriversWithChosenSurname() {
        System.out.println("Введіть прізвище");
        String surname = readFromConsole().trim();
        printDrivers("\tУсі водії з прізвищем " + surname, driverService.getAllDriversBySurname(surname));
    }

    private void driverToTransport() {
        System.out.println("Введіть ID водія і ID транспорту, використовуйте \"|\" в якості розділювача");
        System.out.println("Driver ID | Transport ID");
        String[] slitByBlock = readFromConsole().split("\\|");
        int driverId = Integer.parseInt(slitByBlock[0].trim());
        int transportId=Integer.parseInt(slitByBlock[1].trim());
        driverService.assignDriverToTransport(driverId, transportId);
    }

    private void printDrivers(String title, List<Driver> driverList) {
        System.out.println(title);
        TableList tableListDrivers = new TableList("ID", "Name", "Surname", "Phone number", "Driver license");
        for (Driver driver : driverList) {
            tableListDrivers.addRow(
                    String.valueOf(driver.getId()),
                    driver.getName(),
                    driver.getSurname(),
                    driver.getPhoneNumber(),
                    String.valueOf(driver.getDriverQualificationEnum().getType()));
        }
        tableListDrivers.print();
        driversMenu();
    }

    private void printChosenDriver() {
        System.out.println("Ведіть ID водія якого ви хочете вивести на екран");
        int id = Integer.parseInt(readFromConsole());
        printOneDriver(id);
        driversMenu();
    }

    private void deletingDriver() {
        System.out.println("Ведіть ID водія якого ви хочете видалити");
        int id = Integer.parseInt(readFromConsole());
        driverService.deleteDriver(id);
    }
}
