package training.busboard;



import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {


        String postcode = "RM11 3SQ";

        Utils utils = new Utils();
        Location location = utils.getLongLat(postcode);
        NearbyStops nearbyStops = utils.getNearbyStops(location);

        List<BusStop> busStops = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            BusStop busStop = new BusStop();
            busStop.buses = utils.pullTimes(nearbyStops.stopPoints.get(i).naptanId);

            busStops.add(busStop);
        }

        System.out.println(busStops);
    }
}
