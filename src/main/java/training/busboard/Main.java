package training.busboard;


public class Main {
    public static void main(String args[]) {



        Utils utils = new Utils();

        utils.printTimes(utils.pullTimes(utils.getNearbyStops("RM11 3SQ").stopPoints.get(0).naptanId));

    }
}	
