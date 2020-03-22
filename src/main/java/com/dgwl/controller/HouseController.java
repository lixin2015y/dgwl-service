package com.dgwl.controller;

import com.dgwl.common.ResponseMessage;
import com.dgwl.common.Result;
import com.dgwl.eo.Driver;
import com.dgwl.eo.House;
import com.dgwl.service.DgwlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequestMapping("house")
@RestController
public class HouseController {


    @Autowired
    DgwlService dgwlService;

    @RequestMapping("getArea")
    ResponseMessage getArea() {
        return Result.success(dgwlService.getArea());
    }

    @PostMapping("addHouse")
    ResponseMessage addHouse(House house) {
        if (dgwlService.addHouse(house) > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("getHouse")
    ResponseMessage getHouse(@RequestParam String name, @RequestParam String address, @RequestParam Integer cover) {
        return Result.success(dgwlService.getHouse(name, address, cover));
    }

    @PostMapping("editHouse")
    ResponseMessage editHouse(House house) {
        if (dgwlService.editHouse(house) > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


    @PostMapping("deleteHouse")
    ResponseMessage deleteHouse(@RequestParam Integer id) {
        if (dgwlService.deleteHouse(id) > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

}
