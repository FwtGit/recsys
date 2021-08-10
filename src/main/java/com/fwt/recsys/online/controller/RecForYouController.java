package com.fwt.recsys.online.controller;


import com.fwt.recsys.online.service.RecForYouService;
import com.fwt.recsys.online.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
public class RecForYouController {

    @Autowired
    RecForYouService recForYouService;

    @GetMapping(value = "/getrecforyou",produces="application/json;charset=UTF-8")
    public String movie(@RequestParam("id") String userId, @RequestParam("size") String size, @RequestParam("model") String model) throws IOException, ServletException {
        String movies = recForYouService.doGet(userId,size,model);
        return movies;
    }
}
