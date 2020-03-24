package com.dgwl.service;

import com.dgwl.dao.*;
import com.dgwl.eo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Autowired
    OrderDao orderDao;

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

    @Override
    public List<Map> getMyOrder(Integer userId) {
        return orderDao.selectMyOrder(userId);
    }

    @Override
    public List<Map> getAllOrder() {
        return orderDao.selectAllOrder();
    }

    @Override
    public Integer addOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public Map getPosition(String name) {
        return orderDao.selectPosition(name).get(0);
    }

    @Override
    public Integer deleteOrder(Integer id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public Map getDriversAndHouse() {
        Map map = new HashMap();
        map.put("driverData", orderDao.selectAvailableDriver());
        map.put("houseData", houseDao.selectHouse(null, null, null));
        return map;
    }

    @Override
    public Integer deliverGoods(Order order) {
        return orderDao.deliverGoods(order);
    }

    @Override
    public List<Map> getOrderInHouse(Integer houseId) {
        return orderDao.selectOrderInHouse(houseId);
    }

    @Override
    public Integer handleOrder(Order order) {
        return orderDao.updateOrder(order);
    }
}
