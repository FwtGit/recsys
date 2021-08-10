package com.fwt.recsys.online.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwt.recsys.online.datamanager.DataManager;
import com.fwt.recsys.online.datamanager.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * UserService, return information of a specific user
 */


@Service
public class UserService {

    public String doGet(String userId) throws IOException {
        try {
            //get user object from DataManager
            User user = DataManager.getInstance().getUserById(Integer.parseInt(userId));

            //convert movie object to json format and return
            if (null != user) {
                ObjectMapper mapper = new ObjectMapper();
                String jsonUser = mapper.writeValueAsString(user);
                return jsonUser;
            }else{
                return "";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
