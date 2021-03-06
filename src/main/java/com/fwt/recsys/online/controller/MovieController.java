package com.fwt.recsys.online.controller;


import com.fwt.recsys.online.service.MovieService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/getmovie",produces="application/json;charset=UTF-8")
    public String movie(@RequestParam("id") String id) throws IOException {
        String movie = movieService.doGet(id);
        return movie;
    }

}
