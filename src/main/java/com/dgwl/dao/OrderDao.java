package com.dgwl.dao;

import com.dgwl.eo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    List<Map> selectMyOrder(Integer userId);

    List<Map> selectAllOrder();

    Integer insertOrder(Order order);

    List<Map> selectPosition(@Param("name") String name);

    Integer deleteOrder(Integer id);

    List<Map> selectAvailableDriver();

    Integer deliverGoods(Order order);

    List<Map> selectOrderInHouse(Integer houseId);

    Integer updateOrder(Order order);

    List<Map> selectAllFinishOrder();
}
