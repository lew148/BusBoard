package training.busboard.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.busboard.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class Website {

    @RequestMapping("/")
    ModelAndView home() {
        HomePageModel homePageModel = new HomePageModel();
        return new ModelAndView("index", "homePageModel", homePageModel);
    }

    @RequestMapping("/busInfo")
    ModelAndView busInfo(@RequestParam("postcode") String postcode) {

        Utils utils = new Utils();
        Location location = null;


        try {
            location = utils.getLongLat(postcode);
        } catch (Exception e){
            HomePageModel homePageModel = new HomePageModel();
            homePageModel.errorMessage = "Invalid Postcode! Try Again.";

            return new ModelAndView("index", "homePageModel", homePageModel);
        }

        NearbyStops nearbyStops = utils.getNearbyStops(location);


        List<BusStop> busStops = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            BusStop busStop = new BusStop();
            busStop.buses = utils.pullTimes(nearbyStops.stopPoints.get(i).naptanId);

            busStops.add(busStop);
        }

        BusInfoModel busInfoModel = new BusInfoModel(postcode);
        busInfoModel.busStops = busStops;

        return new ModelAndView("info", "busInfo", busInfoModel);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Website.class, args);
    }

}