package com.dgwl.dao;

import com.dgwl.eo.Car;
import com.dgwl.eo.Driver;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DriverDao {

    Integer insertDriver(Driver driver);

    List<Map> selectDriver(@Param("name") String name, @Param("driveAge") Integer driveAge);

//    void deleteCar(@Param("id") Integer id);
//
//    void updateCar(Car car);
}
