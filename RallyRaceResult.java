import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;

public class RallyRaceResult implements RaceResult {
    
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>(); // Maybe add instance later? 
    }

    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points){
        results.put(driver, points);    
        driver.addPoints(points);
    }
    
    @Override
    public int getDriverPoints(Driver driver){
        return results.getOrDefault(driver, 0);
    }

    public List<Driver> getResults(){

        return results.entrySet().stream().sorted((entry1, entry2) -> Integer.compare(entry2.getValue(),entry1.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
    }

}


