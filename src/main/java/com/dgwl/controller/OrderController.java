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

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    HostHolder hostHolder = new HostHolder();

    @Autowired
    DgwlService dgwlService;

    @PostMapping("getMyOrder")
    ResponseMessage getMyOrder() {
        return Result.success(dgwlService.getMyOrder());
    }

    @PostMapping("addOrder")
    ResponseMessage addOrder(Order order) {
        order.setUserId(hostHolder.getUser().getId());
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
