package com.dgwl.controller;


import com.dgwl.common.ResponseMessage;
import com.dgwl.common.Result;
import com.dgwl.eo.User;
import com.dgwl.model.HostHolder;
import com.dgwl.service.DgwlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    HostHolder hostHolder = new HostHolder();

    @Autowired
    DgwlService dgwlService;

    @PostMapping("login")
    ResponseMessage login(HttpSession session, HttpServletResponse response,
                          @RequestParam String userName, @RequestParam String password) {

        User user = dgwlService.getUser(userName, password);

        if (user == null) {
            return Result.error("未找到帐号或密码错误");
        }

        session.setAttribute("user", user);
        final String sessionId = session.getId();

        return Result.success(sessionId);
    }

    @PostMapping("reg")
    ResponseMessage reg(@RequestParam String userName, @RequestParam String password) {

        Integer integer = dgwlService.checkUserName(userName);

        if (integer != null && integer > 0) {
            return Result.error("用户名已存在");
        }

        dgwlService.reg(userName, password);

        return Result.success();
    }


    @PostMapping("getUser")
    ResponseMessage getUser() {
        return Result.success(hostHolder.getUser());
    }

    @PostMapping("editUser")
    ResponseMessage editUser(User user) {
        if (dgwlService.editUser(user) > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


}
