package com.fwt.recsys.online.controller;


import com.fwt.recsys.online.service.SimilarMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SimilarMovieController {
    @Autowired
    SimilarMovieService similarMovieService;

    @GetMapping(value = "/getsimilarmovie",produces="application/json;charset=UTF-8")
    public String movie(@RequestParam("movieId") String movieId,@RequestParam("size") String size,@RequestParam("model") String model) throws IOException {
        String movies = similarMovieService.doGet(movieId,size,model);
        return movies;
    }

}
