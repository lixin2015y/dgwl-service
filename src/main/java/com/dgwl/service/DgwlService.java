package com.dgwl.service;

import com.dgwl.eo.*;

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

}
