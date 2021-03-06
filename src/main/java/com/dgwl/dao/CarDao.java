package com.dgwl.dao;

import com.dgwl.eo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarDao {

    Integer insertCar(Car car);

    List<Map> selectCar(@Param("number") String number, @Param("type") String type, @Param("load") Integer load);

    List<Map> selectLeaveCar(@Param("number") String number, @Param("type") String type, @Param("load") Integer load);

    void deleteCar(@Param("id") Integer id);

    void updateCar(Car car);
}
