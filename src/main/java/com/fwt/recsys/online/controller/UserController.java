package com.fwt.recsys.online.controller;


import com.fwt.recsys.online.service.MovieService;
import com.fwt.recsys.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/getuser",produces="application/json;charset=UTF-8")
    public String movie(@RequestParam("id") String id) throws IOException {
        String movie = userService.doGet(id);
        return movie;
    }

}
