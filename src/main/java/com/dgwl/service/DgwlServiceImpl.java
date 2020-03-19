package com.dgwl.service;

import com.dgwl.dao.CarDao;
import com.dgwl.dao.DriverDao;
import com.dgwl.dao.UserDao;
import com.dgwl.eo.Car;
import com.dgwl.eo.Driver;
import com.dgwl.eo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DgwlServiceImpl implements DgwlService {


    @Autowired
    UserDao userDao;


    @Autowired
    CarDao carDao;


    @Autowired
    DriverDao driverDao;

    public User getUser(String userName, String password) {
        return userDao.selectUser(userName, password);
    }


    @Override
    public List<Map> getCars(String number, String type, Integer load) {
        return carDao.selectCar(number, type, load);
    }

    @Override
    public void addCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public void deleteCar(Integer id) {
        carDao.deleteCar(id);
    }

    @Override
    public void editCar(Car car) {
        carDao.updateCar(car);
    }

    @Override
    public List<Map> getDrivers(String name, Integer driveAge) {
        return driverDao.selectDriver(name, driveAge);
    }

    @Override
    public Integer addDriver(Driver driver) {
        return driverDao.insertDriver(driver);
    }
}
