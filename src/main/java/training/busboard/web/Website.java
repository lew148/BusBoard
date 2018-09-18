package training.busboard.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.busboard.Bus;
import training.busboard.Utils;

import javax.rmi.CORBA.Util;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class Website {

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/busInfo")
    ModelAndView busInfo(@RequestParam("postcode") String postcode) {


        Utils utils = new Utils();

        List<Bus> buses = utils.getNearestStopInfo(postcode);

        BusInfo busInfo = new BusInfo(postcode);
        busInfo.buses = buses;



        return new ModelAndView("info", "busInfo", busInfo);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Website.class, args);
    }

}