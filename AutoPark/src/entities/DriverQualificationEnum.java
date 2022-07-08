package entities;

public enum DriverQualificationEnum {
    BUS_DRIVER("Автобус"), TRAM_DRIVER("Трамвай");
    private String type;

    DriverQualificationEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
