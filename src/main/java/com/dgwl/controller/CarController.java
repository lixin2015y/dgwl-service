package com.dgwl.controller;

import com.dgwl.common.ResponseMessage;
import com.dgwl.common.Result;
import com.dgwl.eo.Car;
import com.dgwl.service.DgwlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("car")
@RestController
public class CarController {


    @Autowired
    DgwlService dgwlService;

    @RequestMapping("getCars")
    ResponseMessage getCars(@RequestParam String number, @RequestParam String type, @RequestParam Integer load) {

        return Result.success(dgwlService.getCars(number, type, load));
    }


    @RequestMapping("addCar")
    ResponseMessage addCar(Car car) {
        final List<Map> cars = dgwlService.getCars(car.getNumber().trim(), null, null);
        if (cars.size() > 0) {
            return Result.error("此车牌已经登记过");
        }

        dgwlService.addCar(car);

        return Result.success("添加成功！");
    }

    @PostMapping("deleteCar")
    ResponseMessage deleteCar(@RequestParam Integer id) {
        dgwlService.deleteCar(id);
        return Result.success();
    }
}
