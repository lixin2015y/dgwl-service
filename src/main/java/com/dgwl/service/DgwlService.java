package com.dgwl.service;

import com.dgwl.eo.Car;
import com.dgwl.eo.User;

import java.util.List;
import java.util.Map;

public interface DgwlService {


    User getUser(String userName, String password);


    List<Map> getCars(String number, String type, Integer load);

    void addCar(Car car);

    void deleteCar(Integer id);

    void editCar(Car car);

}
