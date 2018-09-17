package training.busboard;


public class Main {
    public static void main(String args[]) {



        GetTimes getTimes;
        getTimes = new GetTimes();


        getTimes.printTimes(getTimes.pullTimes());
    }
}	
