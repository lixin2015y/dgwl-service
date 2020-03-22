package com.dgwl.dao;

import com.dgwl.eo.Area;
import com.dgwl.eo.Driver;
import com.dgwl.eo.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface HouseDao {

    List<Area> selectArea();

    Integer insertHouse(House house);

    List<Map> selectHouse(@Param("name") String name, @Param("address") String address, @Param("cover") Integer cover);

    Integer updateHouse(House house);

    Integer deleteHouse(Integer id);
}
