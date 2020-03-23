package com.dgwl.controller;


import com.dgwl.common.ResponseMessage;
import com.dgwl.common.Result;
import com.dgwl.eo.Order;
import com.dgwl.eo.User;
import com.dgwl.model.HostHolder;
import com.dgwl.service.DgwlService;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.Map;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    HostHolder hostHolder = new HostHolder();

    @Autowired
    DgwlService dgwlService;

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
        double k = 1.0;
        while (Math.abs(k * k - distance) > 1e-5) {
            k = (k + distance / k) / 2;
        }
        order.setPrice(df.format(k * order.getGoodsWeight() * order.getGoodsCapacity()));

        dgwlService.addOrder(order);

        return Result.success();
    }

//    @PostMapping("editUser")
//    ResponseMessage editUser(User user) {
//        if (dgwlService.editUser(user) > 0) {
//            return Result.success();
//        } else {
//            return Result.error();
//        }
//    }


}
