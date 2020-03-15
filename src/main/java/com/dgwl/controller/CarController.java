package com.dgwl.controller;

import com.dgwl.common.ResponseMessage;
import com.dgwl.common.Result;
import com.dgwl.service.DgwlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("car")
@RestController
public class CarController {


    @Autowired
    DgwlService dgwlService;

    @RequestMapping("getCars")
    ResponseMessage getCars() {
        return Result.success(dgwlService.getCars());
    }

}
