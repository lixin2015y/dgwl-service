package com.dgwl.dao;

import com.dgwl.eo.Order;
import com.dgwl.eo.User;
import org.apache.ibatis.annotations.Param;
import org.mockito.internal.matchers.Or;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    List<Map> selectMyOrder();

    Integer insertOrder(Order order);
}
