package com.fwt.recsys.online.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwt.recsys.online.recprocess.RecForYouProcess;
import com.fwt.recsys.online.util.ABTest;
import com.fwt.recsys.online.datamanager.Movie;
import com.fwt.recsys.online.util.Config;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * RecForYouService, provide recommended for you service
 */

@Service
public class RecForYouService extends HttpServlet {
    public String doGet(String userId, String size, String model) throws ServletException,
            IOException {
        try {

            if (Config.IS_ENABLE_AB_TEST){
                model = ABTest.getConfigByUserId(userId);
            }

            //a simple method, just fetch all the movie in the genre
            List<Movie> movies = RecForYouProcess.getRecList(Integer.parseInt(userId), Integer.parseInt(size), model);

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
