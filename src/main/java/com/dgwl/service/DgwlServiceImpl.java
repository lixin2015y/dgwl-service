package com.dgwl.service;

import com.dgwl.dao.CarDao;
import com.dgwl.dao.DriverDao;
import com.dgwl.dao.HouseDao;
import com.dgwl.dao.UserDao;
import com.dgwl.eo.*;
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

    @Autowired
    HouseDao houseDao;

    public User getUser(String userName, String password) {
        return userDao.selectUser(userName, password);
    }


    @Override
    public List<Map> getCars(String number, String type, Integer load) {
        return carDao.selectCar(number, type, load);
    }


    @Override
    public List<Map> getLeaveCars(String number, String type, Integer load) {
        return carDao.selectLeaveCar(number, type, load);
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

    @Override
    public void updateDriver(Driver driver) {
        driverDao.updateDriver(driver);
    }

    @Override
    public void deleteDriver(Integer id) {
        driverDao.deleteDriver(id);
    }

    @Override
    public List<Area> getArea() {
        return houseDao.selectArea();
    }

    @Override
    public Integer addHouse(House house) {
        return houseDao.insertHouse(house);
    }

    @Override
    public List<Map> getHouse(String name, String address, Integer cover) {
        return houseDao.selectHouse(name, address, cover);
    }

    @Override
    public Integer editHouse(House house) {
        return houseDao.updateHouse(house);
    }

    @Override
    public Integer deleteHouse(Integer id) {
        return houseDao.deleteHouse(id);
    }

    @Override
    public Integer editUser(User user) {
        return userDao.updateUser(user);
    }
}
