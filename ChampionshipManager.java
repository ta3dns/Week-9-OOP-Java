
/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 12.03.2025 Lappeenranta
 * 
 * * Championship Manager **
 * 
 *********************************************/

import java.util.ArrayList;
import java.util.List;

 
public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers;
    private static int totalRaces;


    // Constructor
    private ChampionshipManager(){
        drivers = new ArrayList<>();
        races = new ArrayList<>();
        totalDrivers = 0;
        totalRaces = 0;
    }

    // Registering the driver for the race. 
    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }


    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        totalRaces++;
    }

    // Implementing Getters

    public static ChampionshipManager getInstance(){
        if (instance == null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public List<Driver> getDriverStandings(){

        drivers.sort((driver1, driver2) -> Integer.compare(driver2.getPoints(), driver1.getPoints()));
        return new ArrayList<>(drivers);
    }

    public static Driver getLeadingDriver(){
        List<Driver> standings = instance.getDriverStandings();
        return standings.get(0);

    }

    public static int getTotalChampionshipPoints(){

        int totalPoints = 0;
        for (Driver driver : instance.drivers){
            totalPoints += driver.getPoints();
        }

        return totalPoints;
    }

    public static int getTotalRaces(){
        return totalRaces;
    }

    public static int getTotalDrivers(){
        return totalDrivers;
    }

    public List<RallyRaceResult> getRace(){
        return races;
    } 


    
}
