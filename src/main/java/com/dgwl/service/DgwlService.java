package com.dgwl.service;

import com.dgwl.eo.*;
import org.apache.ibatis.annotations.Param;
import org.mockito.internal.matchers.Or;

import java.util.List;
import java.util.Map;

public interface DgwlService {


    User getUser(String userName, String password);


    List<Map> getCars(String number, String type, Integer load);

    List<Map> getLeaveCars(String number, String type, Integer load);

    void addCar(Car car);

    void deleteCar(Integer id);

    void editCar(Car car);

    List<Map> getDrivers(String name, Integer driveAge);

    Integer addDriver(Driver driver);

    void updateDriver(Driver driver);

    void deleteDriver(Integer id);

    List<Area> getArea();

    Integer addHouse(House house);

    List<Map> getHouse(String name, String address, Integer cover);

    Integer editHouse(House house);

    Integer deleteHouse(Integer id);

    Integer editUser(User user);

    List<Map> getMyOrder(Integer userId);

    List<Map> getAllOrder();

    Integer addOrder(Order order);

    Map getPosition(String name);

    Integer deleteOrder(Integer id);

    Map getDriversAndHouse();

    Integer deliverGoods(Order order);


    List<Map> getOrderInHouse(Integer houseId);

    Integer handleOrder(Order order);
}
