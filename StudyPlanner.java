import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 * The StudyPlanner class creates and maintains a daily schedule for each Day object by the hour given an input txt file
 * of events to manage in comma-delimited form
 * Created by danayu on 12/5/16.
 */
public class StudyPlanner {

    String event;
    String weekDay;
    String day;
    int hour;
    int startHour;
    int secondHour;
    int endHour;

    List<Day> listOfDays = new ArrayList<>();

    Day Monday = new Day("Monday");
    Day Tuesday = new Day("Tuesday");
    Day Wednesday = new Day("Wednesday");
    Day Thursday = new Day("Thursday");
    Day Friday = new Day("Friday");

    /**
     * Scans an input txt file and parses it into strings and integer variables
     * @param inputFile
     * @throws FileNotFoundException
     */
    public void readFile(File inputFile) throws FileNotFoundException {
        File file = inputFile;
        String line;
        listOfDays.add(Monday);
        listOfDays.add(Tuesday);
        listOfDays.add(Wednesday);
        listOfDays.add(Thursday);
        listOfDays.add(Friday);

        Scanner sc = new Scanner(file);

        while (sc.hasNext()){

            line = sc.nextLine();

            String[] arrayOfElements = line.split(",");

            event = arrayOfElements[0].toString();
            weekDay = arrayOfElements[1].toString();

            String[] arrayHours = arrayOfElements[2].split("-");

            startHour = Integer.parseInt(arrayHours[0]);
            secondHour = Integer.parseInt(arrayHours[1]);
            endHour = secondHour-1;

            createSchedule(weekDay);

        }

    }

    /**
     * Stores a string event name variable as the value for each integer hour variable key in a HashMap to build
     * an hourly schedule for each Day object
     * @param weekDay
     */

    public void createSchedule(String weekDay){
        this.day = weekDay;
        boolean freeHour;

        for (Day day : listOfDays){

            if (day.getName().equals(weekDay)){

                for (hour = startHour; hour < secondHour; hour++){
                    freeHour = day.getSchedule().get(hour)==null;

                    if (!freeHour) {
                        System.out.println("Not happening. " + event + " overlaps with " + day.getSchedule().get(hour));
                    }

                    else if (freeHour){
                        day.getSchedule().put(hour, event);
                        System.out.println("No overlaps found. " + event + " added at " + hour);
                    }
                }
            }

        }

    }

    //throw NULL POINTER EXCEPTION OR SOME KIND OF EXCEPTION HERE?

    /**
     * Main method for the StudyPlanner program. Takes an input file as input from the command line and instantiates
     * a StudyPlanner object
     * @param args an input file from the command line
     */
    public static void main(String args[]) {

        File file = new File(args[0]);
        StudyPlanner studyPlanner = new StudyPlanner();
        try {
            studyPlanner.readFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
