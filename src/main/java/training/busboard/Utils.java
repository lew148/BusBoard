package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utils {

    Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

    public List<Bus> pullTimes(String stopID) {
                String timesAPI_URL = "https://api.tfl.gov.uk/StopPoint/" + stopID + "/Arrivals";

        List<Bus> buses = client.target(timesAPI_URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Bus>>() {
                });

        Collections.sort(buses, Comparator.comparing(Bus::getTimeToStation));

        return buses;
    }


    public Location getLongLat(String postcode) {

        String longlatAPI_URL = "https://api.postcodes.io/postcodes/" + postcode;


        Location longLat = client.target(longlatAPI_URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<Location>() {
                });

        return longLat;
    }



    public NearbyStops getNearbyStops(Location location) {

        Double latitude = location.result.latitude;
        Double longitude = location.result.longitude;

        String nearbyAPI_URL = "https://api.tfl.gov.uk/StopPoint?stopTypes=NaptanPublicBusCoachTram&radius=500&lat="
                + latitude + "&lon=" + longitude;

        NearbyStops nearbyStops = client.target(nearbyAPI_URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<NearbyStops>() {
                });


        return nearbyStops;
    }

//    public List<Bus> getNearestStopInfo(String postcode, Integer index) {
//        return pullTimes(getNearbyStops(postcode).stopPoints.get(index).naptanId);
//    }
}
