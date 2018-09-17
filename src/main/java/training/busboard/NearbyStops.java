package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbyStops {
    public List<NearbyStopsResults> stopPoints;
}
