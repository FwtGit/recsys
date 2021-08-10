package com.fwt.recsys.online.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwt.recsys.online.datamanager.Movie;
import com.fwt.recsys.online.recprocess.SimilarMovieProcess;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

/**
 * SimilarMovieService, recommend similar movies given by a specific movie
 */

@Service
public class SimilarMovieService extends HttpServlet {
    public String doGet(String movieId, String size, String model) throws IOException {
        try {

            //use SimilarMovieFlow to get similar movies
            List<Movie> movies = SimilarMovieProcess.getRecList(Integer.parseInt(movieId), Integer.parseInt(size), model);

            //convert movie list to json format and return
            ObjectMapper mapper = new ObjectMapper();
            String jsonMovies = mapper.writeValueAsString(movies);
            return jsonMovies;

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
