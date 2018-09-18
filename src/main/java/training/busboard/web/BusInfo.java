package training.busboard.web;


import training.busboard.Bus;

import java.util.List;

public class BusInfo {
    public final String postcode;
    public List<Bus> buses;

    public BusInfo(String postcode) {
        this.postcode = postcode;
    }


}
