import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;


public class ChampionshipStatistics{
    public static double calculateAveragePointsPerDriver(List<Driver> drivers){
        if (drivers.isEmpty()) return 0;
        int totalPoints = 0;
        
        for (Driver driver : drivers){
            totalPoints += driver.getPoints();
        }

        return(double) totalPoints/drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers){
        if (drivers.isEmpty()) return "No Drivers Available";

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver driver : drivers){
            countryPoints.put(driver.getCountry(), countryPoints.getOrDefault(driver.getCountry(), 0) + driver.getPoints());

        }

        return countryPoints.entrySet().stream().max(Entry.comparingByValue()).map(Map.Entry::getKey).orElse("No Data Available");
        
    }

    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRaces();
    }
}