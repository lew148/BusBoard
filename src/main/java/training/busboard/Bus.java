package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bus {

    // name of bus stop
    public String stationName;

    // bus number
    public String lineName;

    // bus stop letters
    public String platformName;

    // current bus destination
    public String destinationName;

    // seconds to bus stop
    public Integer timeToStation;


    public Integer getTimeToStation() {
        return timeToStation;
    }
}
