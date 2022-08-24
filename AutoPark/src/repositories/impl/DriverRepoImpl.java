package repositories.impl;

import entities.Driver;
import repositories.DriverRepo;

import java.util.ArrayList;
import java.util.List;

public class DriverRepoImpl implements DriverRepo {
    private final List<Driver> driverList;

    public DriverRepoImpl() {
        this.driverList = new ArrayList<>();
    }

    @Override
    public boolean addDriver(Driver driver) {
        return driverList.add(driver);
    }

    @Override
    public boolean deleteDriver(int id) {
        return driverList.remove(getDriverById(id));
    }

    @Override
    public Driver getDriverById(int id) {
        for (Driver driver : driverList) {
            if (driver.getId() == id) {
                return driver;
            }
        }
        return null; //TODO Тут краще спочатку перевірити, чи більше введений id ніж list.size(),
        // щоб не перебирати дарма. Також, повертати null не дуже, тоді краще його в Optional завернути додатково.
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverList;
    }


}
