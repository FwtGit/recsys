package com.fwt.recsys;

import com.fwt.recsys.online.datamanager.DataManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecsysApplication {

    public static void main(String[] args) throws Exception {
        //load all the data to DataManager
        DataManager.getInstance().loadData(
                "src/main/resources/static/sampledata/movies.csv",
                "src/main/resources/static/sampledata/links.csv",
                "src/main/resources/static/sampledata/ratings.csv",
                "src/main/resources/static/modeldata/item2vecEmb.csv",
                "src/main/resources/static/modeldata/userEmb.csv",
                "i2vEmb", "uEmb");
        SpringApplication.run(RecsysApplication.class, args);
    }

}
