package training.busboard;



import java.util.List;

public class Main {
    public static void main(String args[]) {


        Utils utils = new Utils();


        List<Bus> buses = utils.getNearestStopInfo("RM11 3SQ");
        System.out.println(buses.get(0).platformName);
    }
}
