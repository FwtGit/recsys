package com.fwt.recsys.online.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwt.recsys.online.datamanager.DataManager;
import com.fwt.recsys.online.datamanager.Movie;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * RecommendationService, provide recommendation service based on different input
 */

@Service
public class RecommendationService extends HttpServlet {
    public String doGet(String genre, String size, String sortby) throws ServletException, IOException {
        try {

            //a simple method, just fetch all the movie in the genre
            List<Movie> movies = DataManager.getInstance().getMoviesByGenre(genre, Integer.parseInt(size),sortby);

            //convert movie list to json format and return
            ObjectMapper mapper = new ObjectMapper();
            String jsonMovies = mapper.writeValueAsString(movies);
            return  jsonMovies;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
