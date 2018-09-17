package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Bus {

    // name of bus stop
    String stationName;

    // bus number
    String lineName;

    // bus stop letters
    String platformName;

    // current bus destination
    String destinationName;

    // seconds to bus stop
    Integer timeToStation;


}
