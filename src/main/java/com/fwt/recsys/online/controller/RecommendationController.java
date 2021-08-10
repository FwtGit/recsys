package com.fwt.recsys.online.controller;


import com.fwt.recsys.online.service.RecommendationService;
import com.fwt.recsys.online.service.SimilarMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    @GetMapping(value = "/getrecommendation",produces="application/json;charset=UTF-8")
    public String movie(@RequestParam("genre") String genre, @RequestParam("size") String size, @RequestParam("sortby") String sortby) throws IOException, ServletException {
        String movies = recommendationService.doGet(genre,size,sortby);
        return movies;
    }
}
