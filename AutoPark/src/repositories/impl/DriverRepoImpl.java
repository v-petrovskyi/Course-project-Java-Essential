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
        if (!isPresent(driver.getId())){
            return driverList.add(driver);
        }
        try {
            throw new Exception("водій з ID " + driver.getId() + " є у базі");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDriver(int id) {
        return driverList.remove(getDriverById(id));
    }

    @Override
    public Driver getDriverById(int id) {
        if (isPresent(id)){
            for (Driver driver : driverList) {
                if (driver.getId() == id) {
                    return driver;
                }
            }
        }
        return null; // TODO Тут краще спочатку перевірити, чи більше введений id ніж list.size(),
                    // щоб не перебирати дарма. Також, повертати null не дуже, тоді краще його в Optional завернути додатково.
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverList;
    }
    @Override
    public boolean isPresent(int id) {
        for (Driver driver : driverList) {
            if (driver.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
