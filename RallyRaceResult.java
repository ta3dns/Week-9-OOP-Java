/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 16.03.2025 Lappeenranta
 * 
 * * RALLY RACE RESULT **
 * 
 *********************************************/


import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RallyRaceResult implements RaceResult {
    
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    // Constructor
    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    // Getters
    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    // Records the result of the race
    @Override
    public void recordResult(Driver driver, int position, int points){
        results.put(driver, points);    
        driver.addPoints(points);
    }
    
    // Returns driver's points in this race
    @Override
    public int getDriverPoints(Driver driver){
        return results.getOrDefault(driver, 0);
    }

    // Returns the sorted reivers in a list. 
    public List<Driver> getResults(){

        List<Driver> drivers = new ArrayList<>(results.keySet());

        drivers.sort((driver1, driver2) ->
            Integer.compare(results.get(driver2), results.get(driver1)));

        return drivers;
    }

}


