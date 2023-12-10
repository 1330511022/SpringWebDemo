package com.example.demo.controller;

import com.example.demo.entity.CommonResult;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@RestController
@Controller()
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @RequestMapping("/show")
    @ResponseBody
    public CommonResult<List<User>> showAll() {
        List<User> data = userService.showAll();
        return new CommonResult<>(1, !data.isEmpty() ? "user有数据" : "user无数据", data);
    }
;

}
