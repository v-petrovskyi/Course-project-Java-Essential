package entities;

public class Driver {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private DriverQualificationEnum driverQualificationEnum;

    public Driver(int id, String name, String surname, String phoneNumber, DriverQualificationEnum driverQualificationEnum) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.driverQualificationEnum = driverQualificationEnum;
    }
}
