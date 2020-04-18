package com.dgwl.controller;


import com.dgwl.common.ResponseMessage;
import com.dgwl.common.Result;
import com.dgwl.eo.Order;
import com.dgwl.model.HostHolder;
import com.dgwl.service.DgwlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    HostHolder hostHolder = new HostHolder();

    @Autowired
    DgwlService dgwlService;

    @Resource
    JdbcTemplate hiveJdbcTemplate;

    @PostMapping("getMyOrder")
    ResponseMessage getMyOrder() {
        return Result.success(dgwlService.getMyOrder(hostHolder.getUser().getId()));
    }

    @PostMapping("addOrder")
    ResponseMessage addOrder(Order order) {
        order.setUserId(hostHolder.getUser().getId());
        //计算价格
        final String[] split = order.getTo().split("-");
        final Map position = dgwlService.getPosition(split[2]);
        System.out.println(position);
        final Double longitude = Double.parseDouble(position.get("longitude").toString());
        final Double latitude = Double.parseDouble(position.get("latitude").toString());
        final double distance = (longitude - 117.190186) * (longitude - 117.190186) + (latitude - 39.125595) * (latitude - 39.125595);
        DecimalFormat df = new DecimalFormat("#.00");
        //开根号
        double k = 1.0;
        while (Math.abs(k * k - distance) > 1e-5) {
            k = (k + distance / k) / 2;
        }
        order.setPrice(df.format(k * order.getGoodsWeight() * order.getGoodsCapacity()));

        dgwlService.addOrder(order);

        return Result.success();
    }

    @PostMapping("getAllOrder")
    ResponseMessage getAllOrder() {
        return Result.success(dgwlService.getAllOrder());
    }

    @PostMapping("deleteOrder")
    ResponseMessage deleteOrder(@RequestParam Integer id) {
        return dgwlService.deleteOrder(id) > 0 ? Result.success() : Result.error();
    }


    @PostMapping("getDriversAndHouse")
    ResponseMessage getDriversAndHouse() {
        return Result.success(dgwlService.getDriversAndHouse());
    }

    @PostMapping("deliverGoods")
    ResponseMessage deliverGoods(Order order) {
        return dgwlService.deliverGoods(order) > 0 ? Result.success() : Result.error();
    }

    @PostMapping("getOrderInHouse")
    ResponseMessage getOrderInHouse(@RequestParam Integer houseId) {
        return Result.success(dgwlService.getOrderInHouse(houseId));
    }


    @PostMapping("handleOrder")
    ResponseMessage handleOrder(Order order) {
        return dgwlService.handleOrder(order) > 0 ? Result.success(dgwlService.getOrderInHouse(order.getHouseId())) : null;
    }

    @PostMapping("getOrderCount")
    ResponseMessage getOrderCount() throws IOException {
        String sql = "select month,count from dgwl.orderresult";
        final List<Map<String, Object>> maps = hiveJdbcTemplate.queryForList(sql);
        return Result.success(maps);
    }


}
