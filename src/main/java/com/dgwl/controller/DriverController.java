package com.dgwl.controller;

import com.dgwl.common.ResponseMessage;
import com.dgwl.common.Result;
import com.dgwl.eo.Car;
import com.dgwl.eo.Driver;
import com.dgwl.service.DgwlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("driver")
@RestController
public class DriverController {


    @Autowired
    DgwlService dgwlService;

    @RequestMapping("getDrivers")
    ResponseMessage getCars(@RequestParam String name, @RequestParam Integer driveAge) {
        final HashMap map = new HashMap();
        map.put("driverData", dgwlService.getDrivers(name, driveAge));
        map.put("carData", dgwlService.getCars("", "", null));
        return Result.success(map);
    }

    @PostMapping("addDriver")
    ResponseMessage addDriver(Driver driver) {
        dgwlService.addDriver(driver);
        return Result.success();
    }

}
