import java.util.HashMap;

/**
 * The Day class initializes an hourly schedule structured as a HashMap
 * Created by danayu on 12/5/16.
 */
public class Day{

    HashMap<Integer, String> hourlySchedule = new HashMap<>();
    String name = null;

    public Day(String weekDay){
        this.hourlySchedule = hourlySchedule;
        this.name = weekDay;
    }

    /**
     * The getSchedule method returns the hourlySchedule HashMap respective to each Day object
     */
    public HashMap<Integer, String> getSchedule(){
        return this.hourlySchedule;
    }

    /**
     * The getName method returns the name of the weekday for each Day object for comparison to events for each day
     * from the input file.
     * @return String weekday name
     */
    public String getName(){
        return this.name;
    }

}
