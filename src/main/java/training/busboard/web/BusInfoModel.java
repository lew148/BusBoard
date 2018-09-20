package training.busboard.web;


import training.busboard.BusStop;
import java.util.List;


public class BusInfoModel {
    public final String postcode;
    public List<BusStop> busStops;

    public BusInfoModel(String postcode) {
        this.postcode = postcode;
    }


}
