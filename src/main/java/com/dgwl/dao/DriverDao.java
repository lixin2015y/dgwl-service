package com.dgwl.dao;

import com.dgwl.eo.Area;
import com.dgwl.eo.Driver;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DriverDao {

    Integer insertDriver(Driver driver);

    List<Map> selectDriver(@Param("name") String name, @Param("driveAge") Integer driveAge);

    Integer updateDriver(Driver driver);

    Integer deleteDriver(Integer id);


}
