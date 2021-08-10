package com.fwt.recsys.online.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwt.recsys.online.datamanager.DataManager;
import com.fwt.recsys.online.datamanager.Movie;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MovieService, return information of a specific movie
 */

@Service
public class MovieService extends HttpServlet {
    public String doGet(String movieId) throws IOException {
        try {

            //get movie object from DataManager
            Movie movie = DataManager.getInstance().getMovieById(Integer.parseInt(movieId));

            //convert movie object to json format and return
            if (null != movie) {
                ObjectMapper mapper = new ObjectMapper();
                String jsonMovie = mapper.writeValueAsString(movie);
                return jsonMovie;
            }else {
                return "";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
