package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        String API_URL = "https://api.tfl.gov.uk/StopPoint/490008660N/Arrivals";

        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

        List<Bus> buses = client.target(API_URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Bus>>(){});


        for (Bus bus : buses){
            String statement;
            statement = "Bus " + bus.lineName + ", heading to " + bus.destinationName + ", will arrive at stop " + bus.platformName +
                    " on " + bus.stationName + " in approx. " + bus.timeToStation/60 + " minutes!";
            System.out.println(statement);
        }


        client.close();
    }
}	
